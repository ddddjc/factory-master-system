package com.djc.entity;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 消息接收者(InformationReceiver)实体类
 *
 * @author djc
 * @since 2023-04-16 14:02:09
 */
@AllArgsConstructor
public class InformationReceiver implements Serializable {
    private static final long serialVersionUID = 881246614439330812L;
    /**
     * 关系id
     */
    private Integer receiverId;
    /**
     * 接收者id
     */
    private Integer employeeId;
    /**
     * 消息id
     */
    private Integer informationId;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 消息状态
     */
    private String informationState;
    /**
     * 消息优先级（紧急程度）
     */
    private String priority;


    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getInformationState() {
        return informationState;
    }

    public void setInformationState(String informationState) {
        this.informationState = informationState;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}

