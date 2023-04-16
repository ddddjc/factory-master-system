package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 出库申请（领材料申请单）(AccessoriesOutbound)实体类
 *
 * @author djc
 * @since 2023-04-16 14:02:11
 */
public class AccessoriesOutbound implements Serializable {
    private static final long serialVersionUID = -22213289288775810L;
    /**
     * 出库id
     */
    private Integer outboundId;
    /**
     * 操作人Id
     */
    private Integer employeeId;
    /**
     * 单据号
     */
    private String document;
    /**
     * 日期
     */
    private Date outboundDate;
    /**
     * 业务员
     */
    private String clerkName;
    /**
     * 出库类别
     */
    private String outboudType;
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
    private String outboundRemark;
    /**
     * 制单人
     */
    private String outboundCreater;
    /**
     * 审核人
     */
    private String outboundReviewer;
    /**
     * 批准人
     */
    private String outboundApprover;
    /**
     * 关闭人
     */
    private String outboundCloser;
    /**
     * 出库单状态
     */
    private String outboundState;
    /**
     * 提交日期
     */
    private Date createDate;


    public Integer getOutboundId() {
        return outboundId;
    }

    public void setOutboundId(Integer outboundId) {
        this.outboundId = outboundId;
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

    public Date getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(Date outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getOutboudType() {
        return outboudType;
    }

    public void setOutboudType(String outboudType) {
        this.outboudType = outboudType;
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

    public String getOutboundRemark() {
        return outboundRemark;
    }

    public void setOutboundRemark(String outboundRemark) {
        this.outboundRemark = outboundRemark;
    }

    public String getOutboundCreater() {
        return outboundCreater;
    }

    public void setOutboundCreater(String outboundCreater) {
        this.outboundCreater = outboundCreater;
    }

    public String getOutboundReviewer() {
        return outboundReviewer;
    }

    public void setOutboundReviewer(String outboundReviewer) {
        this.outboundReviewer = outboundReviewer;
    }

    public String getOutboundApprover() {
        return outboundApprover;
    }

    public void setOutboundApprover(String outboundApprover) {
        this.outboundApprover = outboundApprover;
    }

    public String getOutboundCloser() {
        return outboundCloser;
    }

    public void setOutboundCloser(String outboundCloser) {
        this.outboundCloser = outboundCloser;
    }

    public String getOutboundState() {
        return outboundState;
    }

    public void setOutboundState(String outboundState) {
        this.outboundState = outboundState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

