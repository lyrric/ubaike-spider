package com.github.lyrric.common.constant;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
public class RedisConstant {

    public static final String PRE_FIX = "SPIDER:";
    /** 自增id **/
    public static final String KEY_ID = PRE_FIX + "CURRENT_ID";
    /** 公司信息队列 **/
    public static final String KEY_COMPANY_QUEUE = PRE_FIX + "COMPANY";
    /** 错误信息队列 **/
    public static final String KEY_ERROR_MSG = PRE_FIX + "ERROR";

}
