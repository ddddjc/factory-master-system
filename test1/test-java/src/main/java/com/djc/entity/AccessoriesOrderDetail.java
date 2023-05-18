package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 到货详情(AccessoriesOrderDetail)实体类
 *
 * @author djc
 * @since 2023-05-18 15:17:25
 */
public class AccessoriesOrderDetail implements Serializable {
    private static final long serialVersionUID = -83362516448475388L;
    /**
     * 订单详情id
     */
    private Integer orderDetailId;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 配件id
     */
    private Integer accessoriesId;
    /**
     * 物料类型
     */
    private String materialType;
    /**
     * 订单号
     */
    private Integer orderNumber;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 换算率
     */
    private String conversionRate;
    /**
     * 原币含税单价
     */
    private Integer priceWithTax;
    /**
     * 原币税后单价
     */
    private Integer priceWithoutTax;
    /**
     * 是否批准
     */
    private Integer isApproved;
    /**
     * 批准日期
     */
    private Date approvedDate;
    /**
     * 批准人
     */
    private String approveManagerName;
    /**
     * 是否到货
     */
    private Integer isArrival;
    /**
     * 到货日期
     */
    private Date arrivalDate;
    /**
     * 到货负责人
     */
    private String arrivalManagerName;
    /**
     * 是否退货
     */
    private Integer isReturnable;
    /**
     * 是否入库
     */
    private Integer isInbound;
    /**
     * 入库日期
     */
    private Date inboundDate;
    /**
     * 入库负责人
     */
    private String inboundManagerName;
    /**
     * 退货日期
     */
    private Date returnableDate;
    /**
     * 备注
     */
    private String remark;


    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Integer accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Integer getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(Integer priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public Integer getPriceWithoutTax() {
        return priceWithoutTax;
    }

    public void setPriceWithoutTax(Integer priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
    }

    public Integer getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApproveManagerName() {
        return approveManagerName;
    }

    public void setApproveManagerName(String approveManagerName) {
        this.approveManagerName = approveManagerName;
    }

    public Integer getIsArrival() {
        return isArrival;
    }

    public void setIsArrival(Integer isArrival) {
        this.isArrival = isArrival;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalManagerName() {
        return arrivalManagerName;
    }

    public void setArrivalManagerName(String arrivalManagerName) {
        this.arrivalManagerName = arrivalManagerName;
    }

    public Integer getIsReturnable() {
        return isReturnable;
    }

    public void setIsReturnable(Integer isReturnable) {
        this.isReturnable = isReturnable;
    }

    public Integer getIsInbound() {
        return isInbound;
    }

    public void setIsInbound(Integer isInbound) {
        this.isInbound = isInbound;
    }

    public Date getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }

    public String getInboundManagerName() {
        return inboundManagerName;
    }

    public void setInboundManagerName(String inboundManagerName) {
        this.inboundManagerName = inboundManagerName;
    }

    public Date getReturnableDate() {
        return returnableDate;
    }

    public void setReturnableDate(Date returnableDate) {
        this.returnableDate = returnableDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

