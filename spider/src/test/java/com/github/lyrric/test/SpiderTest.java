package com.github.lyrric.test;

import com.github.lyrric.spider.parser.HtmlParser;
import com.github.lyrric.spider.util.HttpUtil;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
public class SpiderTest {

    public static void main(String[] args) throws IOException {
        new HttpUtil().get("https://www.baidu.com/");
    }
    private static List<Header> getDefaultHeader(){
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

}
