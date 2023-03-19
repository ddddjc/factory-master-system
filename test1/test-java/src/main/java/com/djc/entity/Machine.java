package com.djc.entity;

import java.io.Serializable;

/**
 * 设备表(Machine)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:21
 */
public class Machine implements Serializable {
    private static final long serialVersionUID = 948165319098374263L;
    /**
     * 设备id
     */
    private Integer machineId;
    /**
     * 设备种类id
     */
    private String machineTypeId;
    /**
     * 设备详情信息
     */
    private String machineInformation;
    /**
     * 负责员工id
     */
    private Integer employeeId;


    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(String machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getMachineInformation() {
        return machineInformation;
    }

    public void setMachineInformation(String machineInformation) {
        this.machineInformation = machineInformation;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

}

