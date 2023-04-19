package com.djc.entity;

import com.djc.entity.Vo.MachienVo;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备表(具体到台)(Machine)实体类
 *
 * @author djc
 * @since 2023-04-17 16:21:20
 */
public class Machine implements Serializable {
    private static final long serialVersionUID = -95393418251278698L;
    /**
     * 设备id
     */
    private Integer machineId;
    /**
     * 设备种类id
     */
    private Integer machineTypeId;
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

    public Integer getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Integer machineTypeId) {
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

    public static MachienVo toMachienVo(Machine machine) {
        MachienVo machienVo = new MachienVo();
        machienVo.setAssetNumber(machine.getAssetNumber());
        machienVo.setIntoDate(machine.getIntoDate());
        machienVo.setMachineId(machine.getMachineId());
        machienVo.setMachineLocation(machine.getMachineLocation());
        machienVo.setMachineSerialNumber(machine.getMachineSerialNumber());
        machienVo.setMachineState(machine.getMachineState());
        machienVo.setMachineTypeId(machine.getMachineTypeId());
        machienVo.setRemark(machine.getRemark());

        // Set the remaining properties to null
        machienVo.setMachineManufacturer(null);
        machienVo.setMachineModel(null);
        machienVo.setMachinePower(null);
        machienVo.setMachineTypeInformation(null);
        machienVo.setMachineTypeName(null);
        machienVo.setMachineVoltage(null);
        machienVo.setOrientationPosition(null);

        return machienVo;
    }

}

