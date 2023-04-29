package com.djc.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: djc
 * @Date: 2023-04-29-16:11
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MaintenanceEmployeeVo {
    private static final long serialVersionUID = 177624330112425688L;
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
    /**
     * 关系id
     */
    private Integer maintenanceEmployeeId;
    /**
     * 维护安排id
     */
    private Integer maintenanceArrangeId;
    /**
     * 重要性
     */
    private String importance;
}
