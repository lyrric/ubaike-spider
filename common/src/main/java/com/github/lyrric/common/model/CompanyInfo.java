package com.github.lyrric.common.model;

import lombok.Data;

import java.util.Date;

/**
 * Created on 2020-10-30.
 * 公司信息
 * @author wangxiaodong
 */
@Data
public class CompanyInfo {

  private Long id;
    /** 公司名称 **/
  private String companyName;
  /** 法定代表人 **/
  private String legalRepresentative;
  /** 注册号 **/
  private String registerNumber;
  /** 统一社会信用代码 **/
  private String creditCode;
  /** 注册资本 **/
  private String registerAmount;
  /** 注册日期 **/
  private Date registerDate;
  /** 企业类型 **/
  private String companyType ;
  /** 经营范围 **/
  private String scopeOfBusiness;
  /** 注册地址 **/
  private String registerAddress;
  /** 营业期限 **/
  private String termOfBusiness;
  /** 登记机关 **/
  private String registerAgency;
  /** 经营状态 **/
  private String status;
  /** 创建时间 **/
  private Date createTime;
  /** 修改时间 **/
  private Date updateTime;

}
