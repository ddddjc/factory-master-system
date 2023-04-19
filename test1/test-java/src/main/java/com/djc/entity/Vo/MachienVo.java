package com.djc.entity.Vo;

import com.djc.entity.MachineType;

import java.util.Date;

/**
 * machienVo
 */
@lombok.Data
public class MachienVo {
    /**
     * 资产编号
     */
    private String assetNumber;
    /**
     * 进厂时间
     */
    private Date intoDate;
    /**
     * 设备id
     */
    private Integer machineId;
    /**
     * 机器具体位置
     */
    private String machineLocation;
    /**
     * 制造商
     */
    private String machineManufacturer;
    /**
     * 设备型号
     */
    private String machineModel;
    /**
     * 功率
     */
    private String machinePower;
    /**
     * 设备编号
     */
    private String machineSerialNumber;
    /**
     * 机器状态
     */
    private String machineState;
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
    public void mergeMachineType(MachineType machineType) {
        if (machineType == null) {
            return;
        }

        this.machineTypeName = machineType.getMachineTypeName();
        this.machineTypeInformation = machineType.getMachineTypeInformation();
        this.machineModel = machineType.getMachineModel();
        this.machineManufacturer = machineType.getMachineManufacturer();
        this.orientationPosition = machineType.getOrientationPosition();
        this.machineVoltage = machineType.getMachineVoltage();
        this.machinePower = machineType.getMachinePower();
    }

}