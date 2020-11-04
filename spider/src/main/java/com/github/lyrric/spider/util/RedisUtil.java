package com.github.lyrric.spider.util;

import com.github.lyrric.common.constant.RedisConstant;
import com.github.lyrric.common.model.CompanyInfoModel;
import com.github.lyrric.common.model.ErrorLogModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created on 2020-10-30.
 *
 * @author wangxiaodong
 */
@Slf4j
@Component
public class RedisUtil {

    @Resource
    private Properties properties;


    final String SUCCESS_CODE = "OK";

    private final Gson gson = new Gson();

    private final AtomicLong successCount = new AtomicLong(0);

    /**
     * 存放jedis
     */
    private ThreadLocal<Jedis> jedisThreadLocal = new ThreadLocal<>();

    public Jedis init(){
        Jedis jedis = jedisThreadLocal.get();
        if(jedis == null){
            String host = properties.getProperty("redis.host");
            int port = Integer.parseInt(properties.getProperty("redis.port"));
            String password = properties.getProperty("redis.password");
            jedis = new Jedis(host, port);
            if(StringUtils.isNotEmpty(password) && !SUCCESS_CODE.equals(jedis.auth(password))){
                throw new RuntimeException("redis密码验证失败");
            }
            jedisThreadLocal.set(jedis);
        }
        return jedis;
    }

    /**
     * 获取自增id
     * @return
     */
    public Long getId(){
        final Jedis jedis = init();
        return jedis.incr(RedisConstant.KEY_ID);
    }

    /**
     * 公司信息入队列
     * @param companyInfoModel
     */
    public void pushCompanyInfo(CompanyInfoModel companyInfoModel){
        final Jedis jedis = init();
        long success;
        if((success = successCount.incrementAndGet()) % 100 == 0){
            log.info("已保存保存公司信息数量：{}", success);
        }
        log.debug("保存公司信息：{}", companyInfoModel.getCompanyName());
        jedis.lpush(RedisConstant.KEY_COMPANY_QUEUE, gson.toJson(companyInfoModel));
    }
    /**
     * 错误信息入队列
     * @param err
     */
    public void pushErrorMsg(ErrorLogModel err){
        final Jedis jedis = init();
        log.info("保存错误信息：{}", err.getErrorMsg());
        jedis.lpush(RedisConstant.KEY_ERROR_MSG, gson.toJson(err));
    }
}
