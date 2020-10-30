package com.github.lyrric.spider.core;

import com.github.lyrric.spider.model.HttpProxyInfo;
import com.github.lyrric.spider.proxy.HttpProxy;
import com.github.lyrric.spider.proxy.XieQuHttpProxy;
import com.github.lyrric.spider.util.RedisUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created on 2020-10-30.
 *
 * @author wangxiaodong
 */
@Component
public class Spider {

    /**
     * 代理数据队列
     */
    final BlockingQueue<HttpProxyInfo> proxyInfos;
    /**
     * 代理工具
     */
    @Resource
    HttpProxy proxy;
    @Resource
    private RedisUtil redisUtil;

    /**
     * 线程数量
     */
    final int THREAD_CORE_SIZE = 10;

    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20,
            1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(20),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public Spider() {
        proxyInfos = new LinkedBlockingDeque<>();
    }

    public void start() {
        //创建线程
        for (int i = 0; i < THREAD_CORE_SIZE; i++) {
            executor.submit(this::run);
        }
    }
    /**
     * 爬虫具体执行的逻辑
     */
    public void run(){
        try {

        }catch (Exception e){

        }
        //执行步骤，
        //1:获取redis自增id,拼接爬取的url
        //2:获取http代理
        //3:请求html页面，并解析
        //4：放入redis队列中

    }

    /**
     * 获取一个http代理
     * @return
     */
    private HttpProxyInfo get(){
        HttpProxyInfo proxyInfo = proxyInfos.poll();
        //如果从队列里没有获取到代理信息，则需要重新获取代理信息加入到队列中
        if(proxyInfo == null){
            synchronized (proxyInfos){
                //加入判断，其它线程可能已经新增了代理信息
                if(proxyInfos.size() == 0){
                    //获取代理
                    List<HttpProxyInfo> results = proxy.get();
                    proxyInfos.addAll(results);
                }
                proxyInfo = proxyInfos.poll();
            }
        }
        return proxyInfo;
    }
}
