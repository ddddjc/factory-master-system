package com.djc.entity;

import java.io.Serializable;

/**
 * 维护安排与员工关系表
 * (MaintenanceEmployee)实体类
 *
 * @author djc
 * @since 2023-04-15 15:28:47
 */
public class MaintenanceEmployee implements Serializable {
    private static final long serialVersionUID = 800707500135475089L;
    /**
     * 关系id
     */
    private Integer maintenanceEmployeeId;
    /**
     * 维护安排id
     */
    private Integer maintenanceArrangeId;
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 重要性
     */
    private String importance;
    /**
     * 备注
     */
    private String remark;


    public Integer getMaintenanceEmployeeId() {
        return maintenanceEmployeeId;
    }

    public void setMaintenanceEmployeeId(Integer maintenanceEmployeeId) {
        this.maintenanceEmployeeId = maintenanceEmployeeId;
    }

    public Integer getMaintenanceArrangeId() {
        return maintenanceArrangeId;
    }

    public void setMaintenanceArrangeId(Integer maintenanceArrangeId) {
        this.maintenanceArrangeId = maintenanceArrangeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

