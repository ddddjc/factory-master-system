package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (InventoryChange)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:00
 */
public class InventoryChange implements Serializable {
    private static final long serialVersionUID = 129320642772038768L;
    /**
     * id
     */
    private Integer changeId;
    /**
     * 库存id
     */
    private String inventoryId;
    /**
     * 零件名
     */
    private String accessoriesName;
    /**
     * 改变数量
     */
    private Integer changeNum;
    /**
     * 存取员工
     */
    private String changeEmployeeId;
    /**
     * 修改单位
     */
    private String changeUnit;
    /**
     * 员工名
     */
    private String changeEmployeeName;
    /**
     * 修改类型(入库还是出库）
     */
    private String changeType;
    /**
     * 操作时间
     */
    private Date changeDate;


    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getAccessoriesName() {
        return accessoriesName;
    }

    public void setAccessoriesName(String accessoriesName) {
        this.accessoriesName = accessoriesName;
    }

    public Integer getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(Integer changeNum) {
        this.changeNum = changeNum;
    }

    public String getChangeEmployeeId() {
        return changeEmployeeId;
    }

    public void setChangeEmployeeId(String changeEmployeeId) {
        this.changeEmployeeId = changeEmployeeId;
    }

    public String getChangeUnit() {
        return changeUnit;
    }

    public void setChangeUnit(String changeUnit) {
        this.changeUnit = changeUnit;
    }

    public String getChangeEmployeeName() {
        return changeEmployeeName;
    }

    public void setChangeEmployeeName(String changeEmployeeName) {
        this.changeEmployeeName = changeEmployeeName;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

}

