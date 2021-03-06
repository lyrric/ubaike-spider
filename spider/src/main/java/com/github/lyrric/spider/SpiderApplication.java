package com.github.lyrric.spider;

import com.github.lyrric.spider.proxy.HttpProxy;
import com.github.lyrric.spider.proxy.XieQuHttpProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created on 2020-10-30.
 *
 * @author wangxiaodong
 */
@Configuration
@ComponentScan("com.github.lyrric")
@Slf4j
public class SpiderApplication {

    private static Properties properties = new Properties();


    public static void main(String[] args) {
        //配置启动参数
        for (String arg : args) {
            String key = arg.split("=")[0];
            String value = arg.split("=")[1];
            if(StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)){
                properties.put(key, value);
            }
        }
        new AnnotationConfigApplicationContext(SpiderApplication.class);
    }

    @Bean
    public Properties properties() throws IOException {
        Properties prop = new Properties();
        try (InputStream inputStream = SpiderApplication.class.getResourceAsStream("/application.properties");){
            prop.load(inputStream);
            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                properties.putIfAbsent(entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            log.error("读取application.properties文件时发生错误", e);
            throw e;
        }
        return properties;
    }

    /**
     * 在这里注入你实现的获取代理的类
     * @return
     */
    @Bean
    public HttpProxy httpProxy() {
        return new XieQuHttpProxy();
    }


}
