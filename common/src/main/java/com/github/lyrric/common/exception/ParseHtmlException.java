package com.github.lyrric.common.exception;

/**
 * Created on 2020-11-02.
 * 解析html失败异常
 * @author wangxiaodong
 */
public class ParseHtmlException extends RuntimeException {
    public ParseHtmlException(String message) {
        super(message);
    }
}
