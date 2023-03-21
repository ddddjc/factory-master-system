package com.djc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 维修记录表
 * (MaintenanceRecords)实体类
 *
 * @author djc
 * @since 2023-03-21 21:59:30
 */
public class MaintenanceRecords implements Serializable {
    private static final long serialVersionUID = 438803466460790635L;
    /**
     * 记录id
     */
    private Integer recordsId;
    /**
     * 维修时间
     */
    private Date maintenanceTime;
    /**
     * 机器id
     */
    private Integer machineId;
    /**
     * 维修人id
     */
    private Integer employeeId;
    /**
     * 维修方案描述
     */
    private String methodDescription;
    /**
     * 故障问题描述
     */
    private String faultDescription;
    /**
     * 文档地址
     */
    private String wordPlace;
    /**
     * 图片地址
     */
    private String photoPlace;
    /**
     * 视频地址
     */
    private String vidoPlace;
    /**
     * 机器型号id
     */
    private Integer machineTypeId;


    public Integer getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(Integer recordsId) {
        this.recordsId = recordsId;
    }

    public Date getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Date maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public String getWordPlace() {
        return wordPlace;
    }

    public void setWordPlace(String wordPlace) {
        this.wordPlace = wordPlace;
    }

    public String getPhotoPlace() {
        return photoPlace;
    }

    public void setPhotoPlace(String photoPlace) {
        this.photoPlace = photoPlace;
    }

    public String getVidoPlace() {
        return vidoPlace;
    }

    public void setVidoPlace(String vidoPlace) {
        this.vidoPlace = vidoPlace;
    }

    public Integer getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Integer machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

}

