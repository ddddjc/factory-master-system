package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 待办信息表(Upcoming)实体类
 *
 * @author djc
 * @since 2023-04-15 13:28:46
 */
public class Upcoming implements Serializable {
    private static final long serialVersionUID = 663831667650615468L;
    /**
     * 待办id
     */
    private Integer upcomingId;
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 创建日期
     */
    private Date startDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 截止日期
     */
    private Date deadline;
    /**
     * 待办标题
     */
    private String upcomingTitle;
    /**
     * 描述
     */
    private String upcomingDescription;
    /**
     * 状态
     */
    private String sate;
    /**
     * 创建者
     */
    private String creater;


    public Integer getUpcomingId() {
        return upcomingId;
    }

    public void setUpcomingId(Integer upcomingId) {
        this.upcomingId = upcomingId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getUpcomingTitle() {
        return upcomingTitle;
    }

    public void setUpcomingTitle(String upcomingTitle) {
        this.upcomingTitle = upcomingTitle;
    }

    public String getUpcomingDescription() {
        return upcomingDescription;
    }

    public void setUpcomingDescription(String upcomingDescription) {
        this.upcomingDescription = upcomingDescription;
    }

    public String getSate() {
        return sate;
    }

    public void setSate(String sate) {
        this.sate = sate;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

}

