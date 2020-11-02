package com.github.lyrric.spider.core;

import com.github.lyrric.common.exception.BusinessException;
import com.github.lyrric.common.exception.ParseHtmlException;
import com.github.lyrric.common.model.CompanyInfo;
import com.github.lyrric.common.model.ErrorLog;
import com.github.lyrric.spider.model.HttpProxyInfo;
import com.github.lyrric.spider.parser.HtmlParser;
import com.github.lyrric.spider.proxy.HttpProxy;
import com.github.lyrric.spider.util.HttpUtil;
import com.github.lyrric.spider.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.message.BasicHeader;
import org.jsoup.HttpStatusException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created on 2020-10-30.
 *
 * @author wangxiaodong
 */
@Component
@Slf4j
public class Spider {

    /** 代理数据队列 */
    final BlockingQueue<HttpProxyInfo> proxyInfos;
    /** 线程数量 */
    final int CORE_POOL_SIZE = 10;
    /** 代理工具 */
    @Resource
    HttpProxy proxy;
    @Resource
    private RedisUtil redisUtil;

    private HttpUtil httpUtil;
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30,
            1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(50),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public Spider() {
        proxyInfos = new LinkedBlockingDeque<>();
        httpUtil = new HttpUtil();
    }

    public void start() {
        //创建线程
        for (int i = 0; i < CORE_POOL_SIZE; i++) {
            executor.submit(this::run);
        }
    }
    /**
     * 爬虫具体执行的逻辑
     */
    public void run(){
        //执行步骤，
        //1:获取redis自增id,拼接爬取的url
        //2:获取http代理
        //3:请求html页面，并解析
        //4：放入redis队列中
        Long webId = redisUtil.getId();
        HttpProxyInfo proxy = get();
        do {
            if(proxy == null){
                log.error("thread id {} 没有获取到代理信息，线程退出", Thread.currentThread().getId());
                return;
            }
            String html = null;
            try {
                Date expiry = proxy.getExpiry();
                //判断代理是否过期,提前半秒过期
                //noinspection AlibabaUndefineMagicConstant
                if (expiry != null && expiry.getTime() > (System.currentTimeMillis() - 500)) {
                    proxy = get();
                    continue;
                }
                html = httpUtil.get("https://m.ubaike.cn/show_" + webId + ".html", null, DEFAULT_HEADER,
                        proxy.getIp(), proxy.getPort(), proxy.getScheme());
                if(html == null){
                    //ip被block，重新获取代理
                    proxy = get();
                    continue;
                }
                CompanyInfo companyInfo = HtmlParser.parseHtml(html);
                redisUtil.pushCompanyInfo(companyInfo);
                webId = redisUtil.getId();
            }catch (HttpStatusException e){
                if(e.getStatusCode() == HttpStatus.SC_NOT_FOUND){
                    //404代表没有数据，忽略获取下一个数据
                    webId = redisUtil.getId();
                }else if(e.getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY){
                    //302代表重定向，此IP已被block
                    log.info("http 302：{}，代理信息：{}，判定为ip 被block ，重新获取代理",e.getMessage(), proxy.toString());
                    proxy = get();
                }
            }catch (IOException e){
                //大概率是代理过期，重新尝试即可
                log.info("发生IOException异常：{}，代理信息：{}，判定为ip代理失效，重新获取代理",e.getMessage(), proxy.toString());
                proxy = get();
            }catch (ParseHtmlException | BusinessException e){
                saveErrLog(webId, e.getMessage(), html);
                webId = redisUtil.getId();
            }
        } while (true);


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
                    if(results == null){
                        //没有获取到ip代理信息
                        return null;
                    }
                    proxyInfos.addAll(results);
                }
                proxyInfo = proxyInfos.poll();
            }
        }
        return proxyInfo;
    }

    private final List<Header> DEFAULT_HEADER = getDefaultHeader();

    private List<Header> getDefaultHeader(){
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"));
        headers.add(new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"));
        headers.add(new BasicHeader("accept-encoding","gzip, deflate, br"));
        headers.add(new BasicHeader("accept-language","zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7,zh-TW;q=0.6,la;q=0.5"));
        headers.add(new BasicHeader(":authority","m.ubaike.cn"));
        headers.add(new BasicHeader(":path:","/show_20343794.html"));
        headers.add(new BasicHeader(":scheme","https"));
        headers.add(new BasicHeader("referer","https://m.ubaike.cn/list_1"));
        return headers;
    }

    private void saveErrLog(long webId, String errorMsg, String html) {
        //解析html失败，保存进日志中
        ErrorLog errorLog = new ErrorLog();
        errorLog.setWebId(webId);
        errorLog.setErrorMsg(errorMsg);
        errorLog.setResponseContent(html);
        errorLog.setCreateTime(new Date());
        redisUtil.pushErrorMsg(errorLog);
    }
}
