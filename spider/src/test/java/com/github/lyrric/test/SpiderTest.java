package com.github.lyrric.test;

import com.github.lyrric.spider.util.HttpUtil;
import org.apache.http.NameValuePair;
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
        List<NameValuePair> pairs = new ArrayList<>();
        Integer webId = 20443794;
        pairs.add(new BasicNameValuePair("topic_id", webId.toString()));
        for (int i = 0; i < 999; i++) {
            System.out.print(i+"---");
            System.out.println(new HttpUtil().post("https://m.ubaike.cn/index.php?index/zcziben", pairs));
        }

    }
}
