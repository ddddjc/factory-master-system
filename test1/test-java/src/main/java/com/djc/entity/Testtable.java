package com.djc.entity;

import java.io.Serializable;

/**
 * (Testtable)实体类
 *
 * @author djc
 * @since 2023-04-16 14:02:16
 */
public class Testtable implements Serializable {
    private static final long serialVersionUID = -89077556341752803L;

    private Integer aaid;

    private Integer bbid;


    public Integer getAaid() {
        return aaid;
    }

    public void setAaid(Integer aaid) {
        this.aaid = aaid;
    }

    public Integer getBbid() {
        return bbid;
    }

    public void setBbid(Integer bbid) {
        this.bbid = bbid;
    }

}

