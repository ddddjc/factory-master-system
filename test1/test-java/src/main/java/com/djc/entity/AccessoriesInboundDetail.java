package com.djc.entity;

import java.io.Serializable;

/**
 * 入库详情信息(AccessoriesInboundDetail)实体类
 *
 * @author djc
 * @since 2023-04-15 15:28:58
 */
public class AccessoriesInboundDetail implements Serializable {
    private static final long serialVersionUID = -82426760592635493L;
    /**
     * id
     */
    private Integer inboundDetialId;
    /**
     * 入库单id
     */
    private Integer inboundId;
    /**
     * 零件id
     */
    private Integer accessoriesId;
    /**
     * 物料类型
     */
    private String materialType;
    /**
     * 数量
     */
    private String inboundSum;
    /**
     * 入库日期
     */
    private String inboundDate;
    /**
     * 仓库id
     */
    private Integer depotId;


    public Integer getInboundDetialId() {
        return inboundDetialId;
    }

    public void setInboundDetialId(Integer inboundDetialId) {
        this.inboundDetialId = inboundDetialId;
    }

    public Integer getInboundId() {
        return inboundId;
    }

    public void setInboundId(Integer inboundId) {
        this.inboundId = inboundId;
    }

    public Integer getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Integer accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getInboundSum() {
        return inboundSum;
    }

    public void setInboundSum(String inboundSum) {
        this.inboundSum = inboundSum;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

}

