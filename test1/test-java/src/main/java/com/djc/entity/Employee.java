package com.djc.entity;

import java.io.Serializable;

/**
 * 员工表(Employee)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:20
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 620595650481328852L;
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 员工名字
     */
    private Object employeeName;
    /**
     * 角色
     */
    private String role;
    /**
     * 小组id
     */
    private Integer groupId;
    /**
     * 密码
     */
    private String password;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Object getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(Object employeeName) {
        this.employeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

