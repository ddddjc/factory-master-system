package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 采购信息(AccessoriesProcurement)实体类
 *
 * @author djc
 * @since 2023-04-16 14:02:07
 */
public class AccessoriesProcurement implements Serializable {
    private static final long serialVersionUID = -49186878437645133L;
    /**
     * 采购id
     */
    private Integer procurementId;
    /**
     * 操作人id
     */
    private Integer employeeId;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 订单日期
     */
    private Date procurementDate;
    /**
     * 编号
     */
    private String document;
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
     * 税率
     */
    private String taxRate;
    /**
     * 付款条件
     */
    private String paymentTerms;
    /**
     * 备注
     */
    private String remark;
    /**
     * 发票号
     */
    private String invoiceNumber;
    /**
     * 制单人
     */
    private String procurementCreater;
    /**
     * 审核人
     */
    private String procurementReviewer;
    /**
     * 变更人
     */
    private String procurementChanger;
    /**
     * 批准人
     */
    private String procurementApprover;
    /**
     * 现存量
     */
    private Integer nowNumber;
    /**
     * 申购单状态
     */
    private String procurementState;
    /**
     * 提交日期
     */
    private Date createDate;


    public Integer getProcurementId() {
        return procurementId;
    }

    public void setProcurementId(Integer procurementId) {
        this.procurementId = procurementId;
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

    public Date getProcurementDate() {
        return procurementDate;
    }

    public void setProcurementDate(Date procurementDate) {
        this.procurementDate = procurementDate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getProcurementCreater() {
        return procurementCreater;
    }

    public void setProcurementCreater(String procurementCreater) {
        this.procurementCreater = procurementCreater;
    }

    public String getProcurementReviewer() {
        return procurementReviewer;
    }

    public void setProcurementReviewer(String procurementReviewer) {
        this.procurementReviewer = procurementReviewer;
    }

    public String getProcurementChanger() {
        return procurementChanger;
    }

    public void setProcurementChanger(String procurementChanger) {
        this.procurementChanger = procurementChanger;
    }

    public String getProcurementApprover() {
        return procurementApprover;
    }

    public void setProcurementApprover(String procurementApprover) {
        this.procurementApprover = procurementApprover;
    }

    public Integer getNowNumber() {
        return nowNumber;
    }

    public void setNowNumber(Integer nowNumber) {
        this.nowNumber = nowNumber;
    }

    public String getProcurementState() {
        return procurementState;
    }

    public void setProcurementState(String procurementState) {
        this.procurementState = procurementState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

