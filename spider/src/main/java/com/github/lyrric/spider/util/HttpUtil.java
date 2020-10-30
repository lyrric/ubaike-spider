package com.github.lyrric.spider.util;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created on 2020-10-28.
 *
 * @author wangxiaodong
 */
public class HttpUtil {

    private CloseableHttpClient httpclient;

    public HttpUtil() {
        httpclient = HttpClients.createDefault();
    }

    public String get(String url) throws IOException {
        return get(url, null, null);
    }

    public String get(String url, String proxyHost, Integer port) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        if(StringUtils.isNotEmpty(proxyHost) && port != null){
            // 设置Http代理
            HttpHost proxy = new HttpHost(proxyHost, port, "http");
            RequestConfig config = RequestConfig.custom()
                    .setProxy(proxy)
                    //我猜这里的单位是毫秒
                    .setConnectTimeout(5000)
                    .build();
            httpGet.setConfig(config);
        }
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, Charsets.UTF_8);
        }
    }

}
