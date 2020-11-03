package com.github.lyrric.store.entity;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "error_log")
@ToString
public class ErrorLog extends BaseEntity {

    /**
     * 页面id
     */
    @Column(name = "web_id")
    private Integer webId;

    /**
     * 错误信息
     */
    @Column(name = "error_msg")
    private String errorMsg;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * html内容
     */
    private String html;

    /**
     * 获取页面id
     *
     * @return web_id - 页面id
     */
    public Integer getWebId() {
        return webId;
    }

    /**
     * 设置页面id
     *
     * @param webId 页面id
     */
    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    /**
     * 获取错误信息
     *
     * @return error_msg - 错误信息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置错误信息
     *
     * @param errorMsg 错误信息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取html内容
     *
     * @return html - html内容
     */
    public String getHtml() {
        return html;
    }

    /**
     * 设置html内容
     *
     * @param html html内容
     */
    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }
}