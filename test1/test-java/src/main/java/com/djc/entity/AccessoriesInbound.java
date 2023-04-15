package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 入库信息(AccessoriesInbound)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:06
 */
public class AccessoriesInbound implements Serializable {
    private static final long serialVersionUID = 429506536073729483L;
    /**
     * 入库id
     */
    private Integer inboundId;
    /**
     * 业务员id
     */
    private Integer employeeId;
    /**
     * 单据号
     */
    private String document;
    /**
     * 入库日期
     */
    private Date inboundDate;
    /**
     * 业务员
     */
    private String clerkName;
    /**
     * 入库类别
     */
    private String inboundType;
    /**
     * 审核日期
     */
    private Date reviewDate;
    /**
     * 部门
     */
    private String department;
    /**
     * 备注
     */
    private String inboundRemark;
    /**
     * 制单人
     */
    private String inboundCreater;
    /**
     * 审核人
     */
    private String inboundReviewer;
    /**
     * 批准人
     */
    private String inboundApprover;
    /**
     * 关闭人
     */
    private String inboundCloser;
    /**
     * 入库单状态
     */
    private String inboundState;
    /**
     * 提交日期
     */
    private Date createDate;


    public Integer getInboundId() {
        return inboundId;
    }

    public void setInboundId(Integer inboundId) {
        this.inboundId = inboundId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getInboundType() {
        return inboundType;
    }

    public void setInboundType(String inboundType) {
        this.inboundType = inboundType;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInboundRemark() {
        return inboundRemark;
    }

    public void setInboundRemark(String inboundRemark) {
        this.inboundRemark = inboundRemark;
    }

    public String getInboundCreater() {
        return inboundCreater;
    }

    public void setInboundCreater(String inboundCreater) {
        this.inboundCreater = inboundCreater;
    }

    public String getInboundReviewer() {
        return inboundReviewer;
    }

    public void setInboundReviewer(String inboundReviewer) {
        this.inboundReviewer = inboundReviewer;
    }

    public String getInboundApprover() {
        return inboundApprover;
    }

    public void setInboundApprover(String inboundApprover) {
        this.inboundApprover = inboundApprover;
    }

    public String getInboundCloser() {
        return inboundCloser;
    }

    public void setInboundCloser(String inboundCloser) {
        this.inboundCloser = inboundCloser;
    }

    public String getInboundState() {
        return inboundState;
    }

    public void setInboundState(String inboundState) {
        this.inboundState = inboundState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

