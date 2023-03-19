package com.djc.entity;

import java.io.Serializable;

/**
 * 小组表(Group)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:21
 */
public class Group implements Serializable {
    private static final long serialVersionUID = -58570533939402507L;
    /**
     * 小组id
     */
    private Integer groupId;
    /**
     * 小组长id
     */
    private Integer employeeId;
    /**
     * 小组管理的机器id
     */
    private Integer machineid;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

}

