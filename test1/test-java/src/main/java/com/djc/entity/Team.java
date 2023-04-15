package com.djc.entity;

import java.io.Serializable;

/**
 * 小组表(Team)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:01
 */
public class Team implements Serializable {
    private static final long serialVersionUID = -37457566217646367L;
    /**
     * 小组id
     */
    private Integer teamId;
    /**
     * 小组名
     */
    private String teamName;
    /**
     * 小组长id
     */
    private Integer employeeId;
    /**
     * 小组长名
     */
    private String employeeName;
    /**
     * 组员数量
     */
    private Integer employeeNumber;
    /**
     * 紧急电话
     */
    private String teamNumber;
    /**
     * 小组地点
     */
    private String teamPlace;
    /**
     * 备注
     */
    private String remark;


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

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

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getTeamPlace() {
        return teamPlace;
    }

    public void setTeamPlace(String teamPlace) {
        this.teamPlace = teamPlace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

