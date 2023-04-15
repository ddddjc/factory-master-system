package com.djc.entity;

import java.io.Serializable;

/**
 * 库存(Inventory)实体类
 *
 * @author djc
 * @since 2023-04-15 13:28:52
 */
public class Inventory implements Serializable {
    private static final long serialVersionUID = -96701222317945981L;
    /**
     * 库存id
     */
    private Object inventoryId;
    /**
     * 仓库id
     */
    private Integer depotId;
    /**
     * 配件id
     */
    private Integer accessoriesId;
    /**
     * 零件单位
     */
    private String accessoriesUnit;
    /**
     * 配件数量
     */
    private Integer num;
    /**
     * 零件存放位置
     */
    private String accessoriesLocation;
    /**
     * 零件存放状态
     */
    private String accessoriesState;
    /**
     * 备注
     */
    private String remark;


    public Object getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Object inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    public Integer getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Integer accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public String getAccessoriesUnit() {
        return accessoriesUnit;
    }

    public void setAccessoriesUnit(String accessoriesUnit) {
        this.accessoriesUnit = accessoriesUnit;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getAccessoriesLocation() {
        return accessoriesLocation;
    }

    public void setAccessoriesLocation(String accessoriesLocation) {
        this.accessoriesLocation = accessoriesLocation;
    }

    public String getAccessoriesState() {
        return accessoriesState;
    }

    public void setAccessoriesState(String accessoriesState) {
        this.accessoriesState = accessoriesState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

