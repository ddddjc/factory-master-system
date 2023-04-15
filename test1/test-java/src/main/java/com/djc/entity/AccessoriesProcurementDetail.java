package com.djc.entity;

import java.io.Serializable;

/**
 * 申购详情(AccessoriesProcurementDetail)实体类
 *
 * @author djc
 * @since 2023-04-15 15:54:58
 */
public class AccessoriesProcurementDetail implements Serializable {
    private static final long serialVersionUID = 847193604194426816L;
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
    private String materialType;
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
    private Double originalPriceWithTax;
    /**
     * 原币金额
     */
    private Double originalCurrency;
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

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
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

    public Double getOriginalPriceWithTax() {
        return originalPriceWithTax;
    }

    public void setOriginalPriceWithTax(Double originalPriceWithTax) {
        this.originalPriceWithTax = originalPriceWithTax;
    }

    public Double getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(Double originalCurrency) {
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

