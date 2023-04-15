package com.djc.entity;

import java.time.LocalTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 维护完成汇总(MaintenanceFinishUmmary)实体类
 *
 * @author djc
 * @since 2023-04-15 15:55:05
 */
public class MaintenanceFinishUmmary implements Serializable {
    private static final long serialVersionUID = -83115502721382295L;
    /**
     * 汇总
     */
    private Integer ummmaryId;
    /**
     * 机器id
     */
    private Integer machineId;
    /**
     * 设备名
     */
    private String machineName;
    /**
     * 维护日期
     */
    private Date maintenanceDate;
    /**
     * 开始时间
     */
    private LocalTime startTime;
    /**
     * 结束时间
     */
    private LocalTime endTime;
    /**
     * 维护记录
     */
    private String finishRecording;
    /**
     * 维护状态
     */
    private String maintenanceState;
    /**
     * 重要性
     */
    private String importance;


    public Integer getUmmmaryId() {
        return ummmaryId;
    }

    public void setUmmmaryId(Integer ummmaryId) {
        this.ummmaryId = ummmaryId;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getFinishRecording() {
        return finishRecording;
    }

    public void setFinishRecording(String finishRecording) {
        this.finishRecording = finishRecording;
    }

    public String getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(String maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

}

