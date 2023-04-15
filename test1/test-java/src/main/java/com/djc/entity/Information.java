package com.djc.entity;

import java.io.Serializable;

/**
 * 消息表(Information)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:03
 */
public class Information implements Serializable {
    private static final long serialVersionUID = 225535058601332883L;
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

