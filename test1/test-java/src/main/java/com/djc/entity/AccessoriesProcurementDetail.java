package com.djc.entity;

import java.io.Serializable;

/**
 * 申购详情(AccessoriesProcurementDetail)实体类
 *
 * @author djc
 * @since 2023-04-15 13:28:53
 */
public class AccessoriesProcurementDetail implements Serializable {
    private static final long serialVersionUID = 205064197639868479L;
    /**
     * id
     */
    private Integer procurementDetailId;
    /**
     * 申购id
     */
    private Integer procurementId;
    /**
     * 零件id
     */
    private Integer accessoriesId;
    /**
     * 是否检验
     */
    private String testWhether;
    /**
     * 物料类型
     */
    private String materialType;
    /**
     * 申购数量
     */
    private Integer procurementNum;
    /**
     * 换算率
     */
    private String conversionRate;
    /**
     * 采购单位
     */
    private String purchasingUnit;
    /**
     * 原币含税单价
     */
    private Object originalPriceWithTax;
    /**
     * 原币金额
     */
    private Object originalCurrency;
    /**
     * 原币税额
     */
    private String originalCurrencyTax;
    /**
     * 原币价税合计
     */
    private String totalTaxPriceInOriginalCurrency;
    /**
     * 税率
     */
    private String taxRate;


    public Integer getProcurementDetailId() {
        return procurementDetailId;
    }

    public void setProcurementDetailId(Integer procurementDetailId) {
        this.procurementDetailId = procurementDetailId;
    }

    public Integer getProcurementId() {
        return procurementId;
    }

    public void setProcurementId(Integer procurementId) {
        this.procurementId = procurementId;
    }

    public Integer getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Integer accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public String getTestWhether() {
        return testWhether;
    }

    public void setTestWhether(String testWhether) {
        this.testWhether = testWhether;
    }

    public String getMaterial

    Type() {
        return materialType;
    }

    public void setMaterial

    Type(String materialType) {
        this.materialType = materialType;
    }

    public Integer getProcurementNum() {
        return procurementNum;
    }

    public void setProcurementNum(Integer procurementNum) {
        this.procurementNum = procurementNum;
    }

    public String getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getPurchasingUnit() {
        return purchasingUnit;
    }

    public void setPurchasingUnit(String purchasingUnit) {
        this.purchasingUnit = purchasingUnit;
    }

    public Object getOriginalPriceWithTax() {
        return originalPriceWithTax;
    }

    public void setOriginalPriceWithTax(Object originalPriceWithTax) {
        this.originalPriceWithTax = originalPriceWithTax;
    }

    public Object getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(Object originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getOriginalCurrencyTax() {
        return originalCurrencyTax;
    }

    public void setOriginalCurrencyTax(String originalCurrencyTax) {
        this.originalCurrencyTax = originalCurrencyTax;
    }

    public String getTotalTaxPriceInOriginalCurrency() {
        return totalTaxPriceInOriginalCurrency;
    }

    public void setTotalTaxPriceInOriginalCurrency(String totalTaxPriceInOriginalCurrency) {
        this.totalTaxPriceInOriginalCurrency = totalTaxPriceInOriginalCurrency;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

}

