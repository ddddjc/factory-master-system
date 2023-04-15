package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 到货单(AccessoriesArrival)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:10
 */
public class AccessoriesArrival implements Serializable {
    private static final long serialVersionUID = 796068120152860663L;
    /**
     * 到货表
     */
    private Integer arrivalId;
    /**
     * 操作人id
     */
    private Integer employeeId;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 单据号
     */
    private String document;
    /**
     * 到货日期
     */
    private Date arrivalDate;
    /**
     * 采购类型
     */
    private String purchaseType;
    /**
     * 供应商
     */
    private String vendor;
    /**
     * 部门
     */
    private String department;
    /**
     * 业务员
     */
    private String clerkName;
    /**
     * 币种
     */
    private String currency;
    /**
     * 汇率
     */
    private String exchangeRate;
    /**
     * 运输方式
     */
    private String transportationType;
    /**
     * 税率
     */
    private String taxRate;
    /**
     * 备注
     */
    private String arrivalRemark;
    /**
     * 发票号
     */
    private String invoiceNumber;
    /**
     * 制单人
     */
    private String arrivalCreater;
    /**
     * 现存量
     */
    private Integer nowNum;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 到货到状态
     */
    private String arrivalState;
    /**
     * 记录日期
     */
    private Date createDate;


    public Integer getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(Integer arrivalId) {
        this.arrivalId = arrivalId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getArrivalRemark() {
        return arrivalRemark;
    }

    public void setArrivalRemark(String arrivalRemark) {
        this.arrivalRemark = arrivalRemark;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getArrivalCreater() {
        return arrivalCreater;
    }

    public void setArrivalCreater(String arrivalCreater) {
        this.arrivalCreater = arrivalCreater;
    }

    public Integer getNowNum() {
        return nowNum;
    }

    public void setNowNum(Integer nowNum) {
        this.nowNum = nowNum;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getArrivalState() {
        return arrivalState;
    }

    public void setArrivalState(String arrivalState) {
        this.arrivalState = arrivalState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

