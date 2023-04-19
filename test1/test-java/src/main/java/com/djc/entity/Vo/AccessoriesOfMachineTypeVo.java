// AccessoriesOfMachineTypeVo.java

package com.djc.entity.Vo;

import com.djc.entity.Accessories;

import java.util.List;

/**
 * accessoriesOfMachineTypeVo
 */
@lombok.Data
public class AccessoriesOfMachineTypeVo {
    /**
     * 零件数组
     */
    private List<Accessories> accessoriesList;
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
     * 设备种类id
     */
    private long machineTypeId;
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
}