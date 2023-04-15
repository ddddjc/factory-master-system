package com.djc.entity;

import java.time.LocalTime;
import java.io.Serializable;

/**
 * 仓库信息
 * (Depot)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:13
 */
public class Depot implements Serializable {
    private static final long serialVersionUID = -20099045635665273L;
    /**
     * 仓库id
     */
    private Integer depotId;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 仓库位置
     */
    private String depotLocation;
    /**
     * 负责人
     */
    private Integer employeeId;
    /**
     * 备注
     */
    private String depotRemark;
    /**
     * 联系电话
     */
    private String contactNumber;
    /**
     * 仓库类型
     */
    private String depotType;
    /**
     * 仓库状态
     */
    private String depotState;
    /**
     * 仓库开门时间
     */
    private LocalTime depotOpenedAt;
    /**
     * 仓库关们门间
     */
    private LocalTime depotCloesdAt;


    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getDepotLocation() {
        return depotLocation;
    }

    public void setDepotLocation(String depotLocation) {
        this.depotLocation = depotLocation;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepotRemark() {
        return depotRemark;
    }

    public void setDepotRemark(String depotRemark) {
        this.depotRemark = depotRemark;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDepotType() {
        return depotType;
    }

    public void setDepotType(String depotType) {
        this.depotType = depotType;
    }

    public String getDepotState() {
        return depotState;
    }

    public void setDepotState(String depotState) {
        this.depotState = depotState;
    }

    public LocalTime getDepotOpenedAt() {
        return depotOpenedAt;
    }

    public void setDepotOpenedAt(LocalTime depotOpenedAt) {
        this.depotOpenedAt = depotOpenedAt;
    }

    public LocalTime getDepotCloesdAt() {
        return depotCloesdAt;
    }

    public void setDepotCloesdAt(LocalTime depotCloesdAt) {
        this.depotCloesdAt = depotCloesdAt;
    }

}

