package com.djc.entity;

import java.io.Serializable;

/**
 * 文件表(File)实体类
 *
 * @author djc
 * @since 2023-03-25 13:06:07
 */
public class File implements Serializable {
    private static final long serialVersionUID = 167578931350960018L;
    /**
     * 文件id
     */
    private Integer fileId;
    /**
     * 文件地址
     */
    private String filePlace;
    /**
     * 维修记录id
     */
    private Integer recordsId;
    /**
     * 文件类型
     */
    private String fileType;


    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilePlace() {
        return filePlace;
    }

    public void setFilePlace(String filePlace) {
        this.filePlace = filePlace;
    }

    public Integer getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(Integer recordsId) {
        this.recordsId = recordsId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}

