package com.github.lyrric.store.util;

import com.github.lyrric.common.constant.RedisConstant;
import com.github.lyrric.common.model.CompanyInfoModel;
import com.github.lyrric.common.model.ErrorLogModel;
import com.github.lyrric.store.entity.CompanyInfo;
import com.github.lyrric.store.entity.ErrorLog;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Properties;

/**
 * Created on 2020-10-30.
 *
 * @author wangxiaodong
 */
@Slf4j
public class RedisUtil {

    final String SUCCESS_CODE = "OK";

    private final Gson gson = new Gson();

    private Properties properties;
    /**
     * 存放jedis
     */
    private ThreadLocal<Jedis> jedisThreadLocal = new ThreadLocal<>();

    public RedisUtil(Properties properties) {
        this.properties = properties;
    }

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
     * 弹出公司信息
     */
    public CompanyInfo popCompanyInfo( ){
        final Jedis jedis = init();
        final List<String> data = jedis.brpop(0 ,RedisConstant.KEY_COMPANY_QUEUE);
        String json = data.get(1);
        return gson.fromJson(json, CompanyInfo.class);
    }
    /**
     * 弹出错误信息队列
     */
    public ErrorLog popErrorMsg(){
        final Jedis jedis = init();
        final List<String> data = jedis.brpop(0 ,RedisConstant.KEY_ERROR_MSG);
        String json = data.get(1);
        return gson.fromJson(json, ErrorLog.class);
    }

}
