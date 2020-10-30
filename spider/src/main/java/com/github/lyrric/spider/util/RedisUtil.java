package com.github.lyrric.spider.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;

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

    private final String PRE_FIX = "UBAIKE:";

    /** 自增id **/
    private final String KEY_ID = PRE_FIX + "CURRENT_ID";

    Jedis jedis;

    final String SUCCESS_CODE = "OK";

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
        return jedis.incr(KEY_ID);
    }

}
