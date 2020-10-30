package com.github.lyrric.spider.core;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created on 2020-10-30.
 *
 * @author wangxiaodong
 */
@Component
public class ApplicationRun implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private Spider spider;

    /**
     * 我说这里才是程序入口，你信不信
     * @param event
     */
    @Override
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public void onApplicationEvent(ContextRefreshedEvent event) {
        spider.start();
    }

}
