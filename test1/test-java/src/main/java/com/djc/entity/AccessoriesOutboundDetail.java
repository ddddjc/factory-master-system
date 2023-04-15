package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 出库详情（材料申请表）(AccessoriesOutboundDetail)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:15
 */
public class AccessoriesOutboundDetail implements Serializable {
    private static final long serialVersionUID = 207026504966120116L;
    /**
     * id
     */
    private Integer outboundDetailId;
    /**
     * 出库单id
     */
    private Integer outboundId;
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
    private Integer needNum;
    /**
     * 需求日期
     */
    private Date needDate;
    /**
     * 仓库id
     */
    private Integer depotId;


    public Integer getOutboundDetailId() {
        return outboundDetailId;
    }

    public void setOutboundDetailId(Integer outboundDetailId) {
        this.outboundDetailId = outboundDetailId;
    }

    public Integer getOutboundId() {
        return outboundId;
    }

    public void setOutboundId(Integer outboundId) {
        this.outboundId = outboundId;
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

    public Integer getNeedNum() {
        return needNum;
    }

    public void setNeedNum(Integer needNum) {
        this.needNum = needNum;
    }

    public Date getNeedDate() {
        return needDate;
    }

    public void setNeedDate(Date needDate) {
        this.needDate = needDate;
    }

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

}

