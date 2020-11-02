package com.github.lyrric.spider.util;

import com.github.lyrric.common.constant.RedisConstant;
import com.github.lyrric.common.model.CompanyInfo;
import com.github.lyrric.common.model.ErrorLog;
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

    Jedis jedis;

    final String SUCCESS_CODE = "OK";

    private final AtomicLong successCount = new AtomicLong(0);

    @PostConstruct
    public void init() throws Exception {
        String host = properties.getProperty("redis.host");
        int port = Integer.parseInt(properties.getProperty("redis.port"));
        String password = properties.getProperty("redis.password");
        this.jedis = new Jedis(host, port);
        if(StringUtils.isNotEmpty(password) && !SUCCESS_CODE.equals(jedis.auth(password))){
            throw new Exception("redis密码验证失败");
        }
    }

    /**
     * 获取自增id
     * @return
     */
    public Long getId(){
        return jedis.incr(RedisConstant.KEY_ID);
    }

    /**
     * 公司信息入队列
     * @param companyInfo
     */
    public void pushCompanyInfo(CompanyInfo companyInfo){
        long success;
        if((success = successCount.incrementAndGet()) % 1000 == 0){
            log.info("已保存保存公司信息数量：{}", success);
        }
        log.debug("保存公司信息：{}", companyInfo.getCompanyName());
        jedis.lpush(RedisConstant.KEY_COMPANY_QUEUE, new Gson().toJson(companyInfo));
    }
    /**
     * 错误信息入队列
     * @param err
     */
    public void pushErrorMsg(ErrorLog err){
        log.info("保存错误信息：{}", err.getErrorMsg());
        jedis.lpush(RedisConstant.KEY_ERROR_MSG, new Gson().toJson(err));
    }
}
