package com.github.lyrric.common.exception;

/**
 * Created on 2020-10-30.
 * 自定义的业务异常
 * @author wangxiaodong
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
