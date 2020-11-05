package com.github.lyrric.store.core;

import com.github.lyrric.common.model.CompanyInfoModel;
import com.github.lyrric.common.model.ErrorLogModel;
import com.github.lyrric.store.entity.CompanyInfo;
import com.github.lyrric.store.entity.ErrorLog;
import com.github.lyrric.store.mapper.CompanyInfoMapper;
import com.github.lyrric.store.mapper.ErrorLogMapper;
import com.github.lyrric.store.util.JdbcUtil;
import com.github.lyrric.store.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created on 2020-11-03.
 *
 * @author wangxiaodong
 */
@Slf4j
public class Store {

    private JdbcUtil jdbcUtil;
    private RedisUtil redisUtil;

    /** 线程数量 */
    final int CORE_POOL_SIZE = 2;

    private AtomicLong count = new AtomicLong(0);

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(11, 30,
            1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(50),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    public Store(Properties properties) {
        this.redisUtil = new RedisUtil(properties);
        this.jdbcUtil = new JdbcUtil(properties);
    }

    public void start(){
        for (int i = 0; i < CORE_POOL_SIZE; i++) {
            executor.submit(this::insertCompanyInfo);
        }
        executor.submit(this::insertErrorLog);
    }

    public void insertCompanyInfo(){
        SqlSession sqlSession = jdbcUtil.getSqlSession();
        final CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
        do {
            final CompanyInfo companyInfo = redisUtil.popCompanyInfo();
            try {
                String companyId;
                do {
                    companyId = generateCompanyId();
                }while (mapper.selectCountByCompanyId(companyId) != 0);
                companyInfo.setCompanyId(companyId);
                Date date = new Date();
                companyInfo.setCreateTime(date);
                companyInfo.setUpdateTime(date);
                mapper.insert(companyInfo);
                long t;
                if((t = count.incrementAndGet()) % 1000 == 0){
                    log.info("已保存数据{}条", t);
                }
            }catch (Exception e){
                log.error("保存工商数据时发生错误,{}", companyInfo, e);
            }
        } while (true);
        //sqlSession.close();
    }

    public void insertErrorLog(){
        SqlSession sqlSession = jdbcUtil.getSqlSession();
        final ErrorLogMapper mapper = sqlSession.getMapper(ErrorLogMapper.class);
        do {
            final ErrorLog errorLog = redisUtil.popErrorMsg();
            try {
                mapper.insert(errorLog);
            }catch (Exception e){
                log.error("保存错误日志时发生错误，{}", errorLog, e);
            }
        } while (true);
        //sqlSession.close();
    }

    /**
     * 生成16位的随机I=字符串，作为企业id
     * @return
     */
    public String generateCompanyId(){
        String id = "";
        do {
            id = id.concat(UUID.randomUUID().toString().replaceAll("-", ""));
        } while (id.length() < 18);
        return id.substring(0, 18);
    }
}
