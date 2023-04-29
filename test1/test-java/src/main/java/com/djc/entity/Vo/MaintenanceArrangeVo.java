package com.djc.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-04-29-15:07
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceArrangeVo {
    private static final long serialVersionUID = -12312331261688686L;
    /**
     * 维护id
     */
    private Integer maintenanceArrangeId;
    /**
     * 机器id
     */
    private Integer machineId;
    /**
     * 机器名字
     */
    private String machineName;
    /**
     * 员工名（多个）
     */
    private String employeesName;
    /**
     * 维护日期
     */
    private Date maintenanceDate;
    /**
     * 维护状态（是否完成）
     */
    private String maintenanceState;
    /**
     * 备注
     */
    private String remark;
    /**
     * 员工列表
     */
    private List<MaintenanceEmployeeVo> employeeList;
}
