package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 库存变更记录(AccessEcords)实体类
 *
 * @author djc
 * @since 2023-03-21 21:59:31
 */
public class AccessEcords implements Serializable {
    private static final long serialVersionUID = 131911762284641400L;
    /**
     * id
     */
    private Integer accessRecordsId;
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 零件id
     */
    private Integer accessoriesId;
    /**
     * 变化数量
     */
    private Integer variation;
    /**
     * 存取时间
     */
    private Date accessDate;


    public Integer getAccessRecordsId() {
        return accessRecordsId;
    }

    public void setAccessRecordsId(Integer accessRecordsId) {
        this.accessRecordsId = accessRecordsId;
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

    public Integer getVariation() {
        return variation;
    }

    public void setVariation(Integer variation) {
        this.variation = variation;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

}

