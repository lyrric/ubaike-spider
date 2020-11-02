package com.github.lyrric.store;

import com.github.lyrric.common.constant.RedisConstant;
import com.github.lyrric.common.model.CompanyInfo;
import com.github.lyrric.common.model.ErrorLog;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class RedisUtil {

    Jedis jedis;

    final String SUCCESS_CODE = "OK";

    private final Gson gson = new Gson();

    private final AtomicLong successCount = new AtomicLong(0);

    public RedisUtil(Properties properties){
        String host = properties.getProperty("redis.host");
        int port = Integer.parseInt(properties.getProperty("redis.port"));
        String password = properties.getProperty("redis.password");
        this.jedis = new Jedis(host, port);
        if(StringUtils.isNotEmpty(password) && !SUCCESS_CODE.equals(jedis.auth(password))){
            throw new RuntimeException("redis密码验证失败");
        }
    }

    /**
     * 弹出公司信息
     */
    public CompanyInfo popCompanyInfo( ){
        String json = jedis.lpop(RedisConstant.KEY_COMPANY_QUEUE);
        return gson.fromJson(json, CompanyInfo.class);
    }
    /**
     * 弹出错误信息队列
     */
    public ErrorLog popErrorMsg(){
        String json = jedis.lpop(RedisConstant.KEY_ERROR_MSG);
        return gson.fromJson(json, ErrorLog.class);
    }

}
