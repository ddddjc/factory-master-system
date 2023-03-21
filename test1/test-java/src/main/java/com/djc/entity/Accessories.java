package com.djc.entity;

import java.io.Serializable;

/**
 * 配件表
 * (Accessories)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:20
 */
public class Accessories implements Serializable {
    private static final long serialVersionUID = -69482650934497792L;
    /**
     * 配件id
     */
    private Integer accessoriesId;
    /**
     * 存货编码
     */
    private String stockId;
    /**
     * 存货代码
     */
    private String stockCode;
    /**
     * 配件名字
     */
    private String name;
    /**
     * 计量单位
     */
    private String unit;
    /**
     * 规格型号
     */
    private String model;
    /**
     * 配件所属设备id
     */
    private String machineTypeId;
    /**
     * 重要性
     */
    private Integer importance;
    /**
     * 负责人id
     */
    private Integer employeeId;
    /**
     * 配件类型
     */
    private String type;
    /**
     * 重要性描述
     */
    private String importanceDescription;


    public Integer getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Integer accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(String machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImportanceDescription() {
        return importanceDescription;
    }

    public void setImportanceDescription(String importanceDescription) {
        this.importanceDescription = importanceDescription;
    }

}
