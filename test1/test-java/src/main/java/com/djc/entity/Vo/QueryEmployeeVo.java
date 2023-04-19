package com.djc.entity.Vo;

import com.djc.entity.Employee;
import lombok.Data;

import java.util.Date;

/**
 * queeyEmployeeVo
 */
@Data
public class QueryEmployeeVo extends Employee {
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 部门
     */
    private String department;
    /**
     * 员工邮箱
     */
    private String employeeEmail;
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
     * 员工在职状态
     */
    private String employeeStatus;
    /**
     * 员工入职日期
     */
    private Date hireDate;
    /**
     * 电话
     */
    private String phoneNumber;
    /**
     * 备注
     */
    private String remark;
    /**
     * 角色
     */
    private String role;
    /**
     * 小组id
     */
    private Integer teamId;
    /**
     * 所在小组名
     */
    private String teamName;
    /**
     * 工作地方/办公室
     */
    private String workPlace;
    /**
     * 查询数量
     */
    private Integer allNum;
}