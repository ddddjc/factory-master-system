package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 维护（保养）安排表(MaintenanceArrange)实体类
 *
 * @author djc
 * @since 2023-04-15 15:54:55
 */
public class MaintenanceArrange implements Serializable {
    private static final long serialVersionUID = -27653008287653970L;
    /**
     * 维护id
     */
    private Integer maintenanceArrangeId;
    /**
     * 机器id
     */
    private Integer machineId;
    /**
     * 机器名字
     */
    private String machineName;
    /**
     * 员工名（多个）
     */
    private String employeesName;
    /**
     * 维护日期
     */
    private Date maintenanceDate;
    /**
     * 维护状态（是否完成）
     */
    private String maintenanceState;
    /**
     * 备注
     */
    private String remark;


    public Integer getMaintenanceArrangeId() {
        return maintenanceArrangeId;
    }

    public void setMaintenanceArrangeId(Integer maintenanceArrangeId) {
        this.maintenanceArrangeId = maintenanceArrangeId;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(String maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

