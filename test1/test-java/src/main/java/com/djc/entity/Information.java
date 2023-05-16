package com.djc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 消息表(Information)实体类
 *
 * @author djc
 * @since 2023-04-16 14:02:14
 */
@AllArgsConstructor
@NoArgsConstructor
public class Information implements Serializable {
    private static final long serialVersionUID = 106428929373746493L;
    /**
     * 消息id
     */
    private Integer informationId;
    /**
     * 发送者(employeeid)
     */
    private Integer senderId;
    /**
     * 消息标题
     */
    private String informationTitle;
    /**
     * 消息内容
     */
    private String informationContent;


    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getInformationTitle() {
        return informationTitle;
    }

    public void setInformationTitle(String informationTitle) {
        this.informationTitle = informationTitle;
    }

    public String getInformationContent() {
        return informationContent;
    }

    public void setInformationContent(String informationContent) {
        this.informationContent = informationContent;
    }

}

