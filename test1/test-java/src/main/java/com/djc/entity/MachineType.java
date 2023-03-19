package com.djc.entity;

import java.io.Serializable;

/**
 * 机器类型(MachineType)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:22
 */
public class MachineType implements Serializable {
    private static final long serialVersionUID = 652764534707239516L;
    /**
     * 设备种类id
     */
    private Integer machineTypeId;
    /**
     * 设备种类
     */
    private String machineType;
    /**
     * 设备详情
     */
    private String machineTypeInformation;


    public Integer getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Integer machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineTypeInformation() {
        return machineTypeInformation;
    }

    public void setMachineTypeInformation(String machineTypeInformation) {
        this.machineTypeInformation = machineTypeInformation;
    }

}

