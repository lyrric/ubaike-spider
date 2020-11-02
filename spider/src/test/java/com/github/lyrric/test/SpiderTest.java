package com.github.lyrric.test;

import com.github.lyrric.spider.util.HttpUtil;

import java.io.IOException;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
public class SpiderTest {

    public static void main(String[] args) {
        try {
            String s = new HttpUtil().get("https://m.ubaike.cn/show_20443794.html");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
