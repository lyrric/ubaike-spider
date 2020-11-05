package com.github.lyrric.spider.util;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.HttpStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020-10-28.
 *
 * @author wangxiaodong
 */
public class HttpUtil {

    private CloseableHttpClient httpclient;

    public HttpUtil() {
        //httpclient = HttpClients.createDefault();
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(3000)
                .build();
        httpclient = HttpClients.custom()
                .setDefaultSocketConfig(socketConfig)
                .build();
    }

    public String get(String url) throws IOException {
        return get(url, null,null,null, null, null);
    }
    public String get(String url, Map<String, String> params) throws IOException {
        return get(url, params,null,null, null, null);
    }
    public String get(String url, Map<String, String> params, List<Header> headers) throws IOException {
        return get(url, params,headers,null, null, null);
    }
    public String get(String url, Map<String, String> params, List<Header> headers, String proxyHost, Integer port, String scheme) throws IOException {
        if(params != null && params.size() !=0){
            StringBuilder paramStr = new StringBuilder("?");
            params.forEach((key,value)->{
                paramStr.append(key).append("=").append(value).append("&");
            });
            String t = paramStr.toString();
            if(t.endsWith("&")){
                t = t.substring(0, t.length()-1);
            }
            url+=t;
        }
        HttpGet httpGet = new HttpGet(url);
        setConfig(httpGet, headers, proxyHost, port, scheme);
        return execute(httpGet);
    }

    public String post(String url, List <NameValuePair> pairs, List<Header> headers, String proxyHost, Integer port, String scheme) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs));
        setConfig(httpPost, headers, proxyHost, port, scheme);
        return execute(httpPost);
    }

    private void setConfig(HttpRequestBase http, List<Header> headers, String proxyHost, Integer port, String scheme){
        if(headers != null && headers.size() > 0){
            http.setHeaders(headers.toArray(new Header[0]));
            http.addHeader("Connection", "close");
        }
        RequestConfig.Builder builder = RequestConfig.custom();
        builder.setRedirectsEnabled(false)
                //我猜这里的单位是毫秒
                .setConnectTimeout(3000)
                .setSocketTimeout(3000)
                .setConnectionRequestTimeout(3000);
        if(StringUtils.isNotEmpty(proxyHost) && port != null){
            // 设置Http代理
            HttpHost proxy = new HttpHost(proxyHost, port, scheme);
            builder .setProxy(proxy);
        }
        http.setConfig(builder.build());
    }

    private String execute(HttpRequestBase http) throws IOException {
        try (CloseableHttpResponse response = httpclient.execute(http)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Charsets.UTF_8);
            } else {
                throw new HttpStatusException("状态码异常", statusCode, http.getURI().toString());
            }
        }
    }
}
