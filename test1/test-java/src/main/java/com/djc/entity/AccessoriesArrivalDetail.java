package com.djc.entity;

import java.io.Serializable;

/**
 * 到货详情(AccessoriesArrivalDetail)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:11
 */
public class AccessoriesArrivalDetail implements Serializable {
    private static final long serialVersionUID = -17076345672051078L;
    /**
     * 到达详情id
     */
    private Integer arrivalDetailId;
    /**
     * 到货单id
     */
    private Integer arrivalId;
    /**
     * 配件id
     */
    private Integer accessoriesId;
    /**
     * 是否检验
     */
    private Integer testWether;
    /**
     * 物料类型
     */
    private String materialType;
    /**
     * 订单号
     */
    private Integer orderNumber;
    /**
     * 行号
     */
    private Integer lineNumber;
    /**
     * 到货数量
     */
    private Integer arrivalNum;
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


    public Integer getArrivalDetailId() {
        return arrivalDetailId;
    }

    public void setArrivalDetailId(Integer arrivalDetailId) {
        this.arrivalDetailId = arrivalDetailId;
    }

    public Integer getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(Integer arrivalId) {
        this.arrivalId = arrivalId;
    }

    public Integer getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Integer accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public Integer getTestWether() {
        return testWether;
    }

    public void setTestWether(Integer testWether) {
        this.testWether = testWether;
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

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getArrivalNum() {
        return arrivalNum;
    }

    public void setArrivalNum(Integer arrivalNum) {
        this.arrivalNum = arrivalNum;
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

}

