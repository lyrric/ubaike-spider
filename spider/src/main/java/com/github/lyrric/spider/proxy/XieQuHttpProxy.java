package com.github.lyrric.spider.proxy;

import com.github.lyrric.spider.model.HttpProxyInfo;
import com.github.lyrric.spider.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created on 2020-10-30.
 * 携趣http代理 https://www.xiequ.cn/
 * @author wangxiaodong
 */
@Slf4j
public class XieQuHttpProxy implements HttpProxy {

    HttpUtil httpUtil = new HttpUtil();


    @Override
    public List<HttpProxyInfo> get() {
        //重试五次，避免因网络波动导致获取失败
        for (int i = 0; i < 5; i++) {
            try {
                String json = httpUtil.get(
                        "http://api.xiequ.cn/VAD/GetIp.aspx?act=get&num=10&time=60&plat=0&re=1&type=2&so=1&ow=1&spl=1&addr=&db=1");
                log.info("获取ip代理成功:{}", json);
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                JsonArray data = jsonObject.getAsJsonArray("data");
                Type collectionType = new TypeToken<List<ProxyInfo>>(){}.getType();
                List<ProxyInfo> proxyInfoList = new Gson().fromJson(data, collectionType);
                List<HttpProxyInfo> result = new ArrayList<>(proxyInfoList.size());
                for (ProxyInfo proxyInfo : proxyInfoList) {
                    HttpProxyInfo info = new HttpProxyInfo();
                    info.setIp(proxyInfo.getIp());
                    info.setPort(proxyInfo.getPort());
                    info.setScheme("http");
                    result.add(info);
                }
                return result;
            } catch (IOException e) {
                log.error("获取代理失败，尝试重试：{}", i, e);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    @Data
    private static class ProxyInfo{
        /**
         * 代理ip地址
         */
        @SerializedName("IP")
        private String ip;
        /**
         * 代理端口
         */
        @SerializedName("Port")
        private Integer port;
    }
}
