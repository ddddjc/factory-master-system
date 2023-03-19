package com.djc.entity;

import java.io.Serializable;

/**
 * (EmployeeMachine)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:20
 */
public class EmployeeMachine implements Serializable {
    private static final long serialVersionUID = -98142119177616335L;

    private Integer employeeId;

    private Integer machineId;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

}

