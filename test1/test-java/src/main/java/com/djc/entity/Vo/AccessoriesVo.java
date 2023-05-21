package com.djc.entity.Vo;

import com.djc.entity.Accessories;

/**
 * accessoriesVo
 */

@lombok.Data
public class AccessoriesVo {
    /**
     * 配件id
     */
    private Integer accessoriesId;
    /**
     * 配件名字
     */
    private String accessoriesName;
    /**
     * 负责人id
     */
    private Integer employeeId;
    /**
     * 负责人名字
     */
    private String employeeName;
    /**
     * 重要性
     */
    private Integer importance;
    /**
     * 重要性描述
     */
    private String importanceDescription;
    /**
     * 配件所属设备id
     */
    private Integer machineTypeId;
    /**
     * 规格型号
     */
    private String model;
    /**
     * 存货代码
     */
    private String stockCode;
    /**
     * 存货编码
     */
    private String stockId;
    /**
     * 配件类型（excl表名）
     */
    private String type;
    /**
     * 计量单位
     */
    private String unit;

}