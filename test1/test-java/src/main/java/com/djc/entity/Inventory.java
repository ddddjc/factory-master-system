package com.djc.entity;

import java.io.Serializable;

/**
 * 库存(Inventory)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:21
 */
public class Inventory implements Serializable {
    private static final long serialVersionUID = -58933590774799985L;

    private Integer inventoryId;

    private Integer employeeId;

    private Integer accessoriesId;

    private Integer num;


    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Integer accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}

