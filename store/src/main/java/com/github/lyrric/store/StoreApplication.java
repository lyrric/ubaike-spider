package com.github.lyrric.store;

import com.github.lyrric.store.core.Store;
import com.github.lyrric.store.entity.CompanyInfo;
import com.github.lyrric.store.util.JdbcUtil;
import com.github.lyrric.store.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
@Slf4j
public class StoreApplication {


    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //配置启动参数
        for (String arg : args) {
            String key = arg.split("=")[0];
            String value = arg.split("=")[1];
            if(StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)){
                properties.put(key, value);
            }
        }
        Properties prop = new Properties();
        try (InputStream inputStream = StoreApplication.class.getResourceAsStream("/application.properties");){
            prop.load(inputStream);
            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                properties.putIfAbsent(entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            log.error("读取application.properties文件时发生错误", e);
            throw e;
        }
        new Store(properties).start();
    }


}

