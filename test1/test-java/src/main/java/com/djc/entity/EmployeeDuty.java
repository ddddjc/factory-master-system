package com.djc.entity;

import java.io.Serializable;

/**
 * 小组值班分工(EmployeeDuty)实体类
 *
 * @author djc
 * @since 2023-04-15 15:29:01
 */
public class EmployeeDuty implements Serializable {
    private static final long serialVersionUID = 642942298634790401L;
    /**
     * 值班id
     */
    private Integer dutyId;
    /**
     * 责任人id
     */
    private Integer employeeId;
    /**
     * 责任人名字
     */
    private String employeeName;
    /**
     * 机器级别
     */
    private String nachineLevel;
    /**
     * 机器类型id
     */
    private Integer machineTypeId;
    /**
     * 机器名
     */
    private String machineTypeName;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 在用数量
     */
    private Integer usingNum;
    /**
     * 在用区域
     */
    private String usingRegion;
    /**
     * 停用数量
     */
    private Integer deactivateNum;
    /**
     * 停用区域
     */
    private String deactivateRegion;
    /**
     * 呆滞数量
     */
    private Integer sluggishNum;
    /**
     * 呆滞区域
     */
    private String sluggishRegion;
    /**
     * 备注
     */
    private String dutyRemark;


    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
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

    public String getNachineLevel() {
        return nachineLevel;
    }

    public void setNachineLevel(String nachineLevel) {
        this.nachineLevel = nachineLevel;
    }

    public Integer getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Integer machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUsingNum() {
        return usingNum;
    }

    public void setUsingNum(Integer usingNum) {
        this.usingNum = usingNum;
    }

    public String getUsingRegion() {
        return usingRegion;
    }

    public void setUsingRegion(String usingRegion) {
        this.usingRegion = usingRegion;
    }

    public Integer getDeactivateNum() {
        return deactivateNum;
    }

    public void setDeactivateNum(Integer deactivateNum) {
        this.deactivateNum = deactivateNum;
    }

    public String getDeactivateRegion() {
        return deactivateRegion;
    }

    public void setDeactivateRegion(String deactivateRegion) {
        this.deactivateRegion = deactivateRegion;
    }

    public Integer getSluggishNum() {
        return sluggishNum;
    }

    public void setSluggishNum(Integer sluggishNum) {
        this.sluggishNum = sluggishNum;
    }

    public String getSluggishRegion() {
        return sluggishRegion;
    }

    public void setSluggishRegion(String sluggishRegion) {
        this.sluggishRegion = sluggishRegion;
    }

    public String getDutyRemark() {
        return dutyRemark;
    }

    public void setDutyRemark(String dutyRemark) {
        this.dutyRemark = dutyRemark;
    }

}

