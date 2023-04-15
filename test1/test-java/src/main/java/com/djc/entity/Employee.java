package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工表(Employee)实体类
 *
 * @author djc
 * @since 2023-04-15 13:28:52
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = -43546783066709645L;
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 员工名字
     */
    private String employeeName;
    /**
     * 性别
     */
    private String employeeSex;
    /**
     * 员工年龄
     */
    private Integer age;
    /**
     * 角色
     */
    private String role;
    /**
     * 小组id
     */
    private Integer teamId;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phoneNumber;
    /**
     * 工作地方/办公室
     */
    private String workPlace;
    /**
     * 部门
     */
    private String department;
    /**
     * 员工邮箱
     */
    private String employeeEmail;
    /**
     * 员工在职状态
     */
    private String employeeStatus;
    /**
     * 备注
     */
    private String remark;
    /**
     * 员工入职日期
     */
    private Date hireDate;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

}

