package com.github.lyrric.spider.util;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.HttpStatusException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

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
        if(headers != null && headers.size() > 0){
            httpGet.setHeaders(headers.toArray(new Header[0]));
        }
        RequestConfig.Builder builder = RequestConfig.custom();
        builder.setRedirectsEnabled(false)
                //我猜这里的单位是毫秒
                .setConnectTimeout(5000);
        if(StringUtils.isNotEmpty(proxyHost) && port != null){
            // 设置Http代理
            HttpHost proxy = new HttpHost(proxyHost, port, scheme);
            builder .setProxy(proxy);
        }
        httpGet.setConfig(builder.build());
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Charsets.UTF_8);
            }else {
                throw new HttpStatusException("状态码异常", statusCode, url);
            }

        }
    }

    public String post(String url, List <NameValuePair> pairs) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Charsets.UTF_8);
            }else {
                throw new HttpStatusException("状态码异常", statusCode, url);
            }
        } finally {
            response.close();
        }
    }

}
