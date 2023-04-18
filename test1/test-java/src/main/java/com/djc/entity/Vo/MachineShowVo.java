package com.djc.entity.Vo;

import com.djc.entity.MachineType;

/**
 * machineShowVo
 */
@lombok.Data
public class MachineShowVo {
    /**
     * 制造商
     */
    private String machineManufacturer;
    /**
     * 设备型号
     */
    private String machineModel;
    /**
     * 对应机器数量
     */
    private Integer machineNum;
    /**
     * 功率
     */
    private String machinePower;
    /**
     * 设备种类id
     */
    private Integer machineTypeId;
    /**
     * 设备详情
     */
    private String machineTypeInformation;
    /**
     * 设备种类
     */
    private String machineTypeName;
    /**
     * 电压
     */
    private String machineVoltage;
    /**
     * 定向位置
     */
    private String orientationPosition;
    /**
     * 备注
     */
    private String remark;
    public void fillFromMachineType(MachineType machineType) {
        this.setMachineManufacturer(machineType.getMachineManufacturer());
        this.setMachineModel(machineType.getMachineModel());
        this.setMachinePower(machineType.getMachinePower());
        this.setMachineTypeId(machineType.getMachineTypeId());
        this.setMachineTypeInformation(machineType.getMachineTypeInformation());
        this.setMachineTypeName(machineType.getMachineTypeName());
        this.setMachineVoltage(machineType.getMachineVoltage());
        this.setOrientationPosition(machineType.getOrientationPosition());
        this.setRemark(machineType.getRemark());
    }

}