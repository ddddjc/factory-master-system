package com.djc.entity;

import java.io.Serializable;

/**
 * 文件表(File)实体类
 *
 * @author djc
 * @since 2023-04-15 13:28:56
 */
public class File implements Serializable {
    private static final long serialVersionUID = -95218130900212999L;
    /**
     * 文件id
     */
    private Integer fileId;
    /**
     * 维修记录id
     */
    private Integer recordsId;
    /**
     * 文件地址
     */
    private String filePlace;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件大小
     */
    private Object fileSize;


    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(Integer recordsId) {
        this.recordsId = recordsId;
    }

    public String getFilePlace() {
        return filePlace;
    }

    public void setFilePlace(String filePlace) {
        this.filePlace = filePlace;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Object getFileSize() {
        return fileSize;
    }

    public void setFileSize(Object fileSize) {
        this.fileSize = fileSize;
    }

}

