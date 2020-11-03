package com.github.lyrric.store.entity;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "company_info")
@ToString
public class CompanyInfo extends BaseEntity {

    /**
     * 公司id，由代码生成
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 法定代表人
     */
    @Column(name = "legal_representative")
    private String legalRepresentative;

    /**
     * 注册号
     */
    @Column(name = "register_number")
    private String registerNumber;

    /**
     * 统一社会信用代码
     */
    @Column(name = "credit_code")
    private String creditCode;

    /**
     * 注册资本
     */
    @Column(name = "register_amount")
    private String registerAmount;

    /**
     * 注册日期
     */
    @Column(name = "register_date")
    private Date registerDate;

    /**
     * 企业类型
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 注册地址
     */
    @Column(name = "register_address")
    private String registerAddress;

    /**
     * 营业期限
     */
    @Column(name = "term_of_business")
    private String termOfBusiness;

    /**
     * 登记机关
     */
    @Column(name = "register_agency")
    private String registerAgency;

    /**
     * 经营状态
     */
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 经营范围
     */
    @Column(name = "scope_of_business")
    private String scopeOfBusiness;

    /**
     * 获取公司id，由代码生成
     *
     * @return company_id - 公司id，由代码生成
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id，由代码生成
     *
     * @param companyId 公司id，由代码生成
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取法定代表人
     *
     * @return legal_representative - 法定代表人
     */
    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param legalRepresentative 法定代表人
     */
    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    /**
     * 获取注册号
     *
     * @return register_number - 注册号
     */
    public String getRegisterNumber() {
        return registerNumber;
    }

    /**
     * 设置注册号
     *
     * @param registerNumber 注册号
     */
    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber == null ? null : registerNumber.trim();
    }

    /**
     * 获取统一社会信用代码
     *
     * @return credit_code - 统一社会信用代码
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param creditCode 统一社会信用代码
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    /**
     * 获取注册资本
     *
     * @return register_amount - 注册资本
     */
    public String getRegisterAmount() {
        return registerAmount;
    }

    /**
     * 设置注册资本
     *
     * @param registerAmount 注册资本
     */
    public void setRegisterAmount(String registerAmount) {
        this.registerAmount = registerAmount == null ? null : registerAmount.trim();
    }

    /**
     * 获取注册日期
     *
     * @return register_date - 注册日期
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置注册日期
     *
     * @param registerDate 注册日期
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 获取企业类型
     *
     * @return company_type - 企业类型
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * 设置企业类型
     *
     * @param companyType 企业类型
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * 获取注册地址
     *
     * @return register_address - 注册地址
     */
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**
     * 设置注册地址
     *
     * @param registerAddress 注册地址
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    /**
     * 获取营业期限
     *
     * @return term_of_business - 营业期限
     */
    public String getTermOfBusiness() {
        return termOfBusiness;
    }

    /**
     * 设置营业期限
     *
     * @param termOfBusiness 营业期限
     */
    public void setTermOfBusiness(String termOfBusiness) {
        this.termOfBusiness = termOfBusiness == null ? null : termOfBusiness.trim();
    }

    /**
     * 获取登记机关
     *
     * @return register_agency - 登记机关
     */
    public String getRegisterAgency() {
        return registerAgency;
    }

    /**
     * 设置登记机关
     *
     * @param registerAgency 登记机关
     */
    public void setRegisterAgency(String registerAgency) {
        this.registerAgency = registerAgency == null ? null : registerAgency.trim();
    }

    /**
     * 获取经营状态
     *
     * @return status - 经营状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置经营状态
     *
     * @param status 经营状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取经营范围
     *
     * @return scope_of_business - 经营范围
     */
    public String getScopeOfBusiness() {
        return scopeOfBusiness;
    }

    /**
     * 设置经营范围
     *
     * @param scopeOfBusiness 经营范围
     */
    public void setScopeOfBusiness(String scopeOfBusiness) {
        this.scopeOfBusiness = scopeOfBusiness == null ? null : scopeOfBusiness.trim();
    }
}