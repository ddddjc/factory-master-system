package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 设备表(具体到台)(Machine)实体类
 *
 * @author djc
 * @since 2023-04-15 15:29:04
 */
public class Machine implements Serializable {
    private static final long serialVersionUID = -56161822457271149L;
    /**
     * 设备id
     */
    private Integer machineId;
    /**
     * 设备种类id
     */
    private String machineTypeId;
    /**
     * 设备编号
     */
    private String machineSerialNumber;
    /**
     * 机器具体位置
     */
    private String machineLocation;
    /**
     * 进厂时间
     */
    private Date intoDate;
    /**
     * 资产编号
     */
    private String assetNumber;
    /**
     * 机器状态
     */
    private String machineState;
    /**
     * 备注
     */
    private String remark;


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

    public String getMachineSerialNumber() {
        return machineSerialNumber;
    }

    public void setMachineSerialNumber(String machineSerialNumber) {
        this.machineSerialNumber = machineSerialNumber;
    }

    public String getMachineLocation() {
        return machineLocation;
    }

    public void setMachineLocation(String machineLocation) {
        this.machineLocation = machineLocation;
    }

    public Date getIntoDate() {
        return intoDate;
    }

    public void setIntoDate(Date intoDate) {
        this.intoDate = intoDate;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getMachineState() {
        return machineState;
    }

    public void setMachineState(String machineState) {
        this.machineState = machineState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

