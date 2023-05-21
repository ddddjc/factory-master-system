package com.djc.entity;

import java.io.Serializable;

/**
 * (AccessoriesType)实体类
 *
 * @author djc
 * @since 2023-05-21 15:29:17
 */
public class AccessoriesType implements Serializable {
    private static final long serialVersionUID = -28490851126386287L;
    /**
     * 类型id
     */
    private Integer typeId;
    /**
     * 类型
     */
    private String type;
    /**
     * 功能
     */
    private String typeFunction;
    /**
     * 描述
     */
    private String typeDescription;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeFunction() {
        return typeFunction;
    }

    public void setTypeFunction(String typeFunction) {
        this.typeFunction = typeFunction;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

}

