package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 到货单(AccessoriesOrder)实体类
 *
 * @author djc
 * @since 2023-05-18 15:17:24
 */
public class AccessoriesOrder implements Serializable {
    private static final long serialVersionUID = 704608768597743909L;
    /**
     * 订单表
     */
    private Integer orderId;
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
     * 提交日期
     */
    private Date orderDate;
    /**
     * 采购类型
     */
    private String purchaseType;
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
    private String orderRemark;
    /**
     * 制单人
     */
    private String orderCreater;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 记录日期
     */
    private Date createDate;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
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

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getOrderCreater() {
        return orderCreater;
    }

    public void setOrderCreater(String orderCreater) {
        this.orderCreater = orderCreater;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

