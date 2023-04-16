package com.djc.entity;

import java.io.Serializable;

/**
 * 维修请求(RepairRequest)实体类
 *
 * @author djc
 * @since 2023-04-16 14:02:17
 */
public class RepairRequest implements Serializable {
    private static final long serialVersionUID = 352789396419716258L;
    /**
     * 维修请求id
     */
    private Integer requestId;
    /**
     * 机器id
     */
    private Integer machineId;
    /**
     * 机器名
     */
    private String machineName;
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 申请人名字
     */
    private String employeeName;
    /**
     * 紧急程度
     */
    private String degreeUrgency;
    /**
     * 情况描述
     */
    private String description;
    /**
     * 联系电话号码
     */
    private String telephoneNumber;
    /**
     * 具体位置
     */
    private String specificPosition;
    /**
     * 进展
     */
    private String progress;


    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDegreeUrgency() {
        return degreeUrgency;
    }

    public void setDegreeUrgency(String degreeUrgency) {
        this.degreeUrgency = degreeUrgency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getSpecificPosition() {
        return specificPosition;
    }

    public void setSpecificPosition(String specificPosition) {
        this.specificPosition = specificPosition;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

}

