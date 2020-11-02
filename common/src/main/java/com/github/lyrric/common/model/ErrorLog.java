package com.github.lyrric.common.model;

import lombok.Data;

import java.util.Date;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
@Data
public class ErrorLog {

    private Long id;
    /** 页面id **/
    private Long webId;
    /** 错误信息 **/
    private String errorMsg;
    /** html内容 **/
    private String responseContent;
    /** 创建时间 **/
    private Date createTime;
}
