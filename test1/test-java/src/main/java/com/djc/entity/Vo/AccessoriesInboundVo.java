package com.djc.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-05-01-1:46
 * @Description:
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class AccessoriesInboundVo {
    /**
     * 入库id
     */
    private Integer inboundId;
    /**
     * 业务员id
     */
    private Integer employeeId;
    /**
     * 单据号
     */
    private String document;
    /**
     * 入库日期
     */
    private Date inboundDate;
    /**
     * 业务员
     */
    private String clerkName;
    /**
     * 入库类别
     */
    private String inboundType;
    /**
     * 审核日期
     */
    private Date reviewDate;
    /**
     * 部门
     */
    private String department;
    /**
     * 备注
     */
    private String inboundRemark;
    /**
     * 制单人
     */
    private String inboundCreater;
    /**
     * 审核人
     */
    private String inboundReviewer;
    /**
     * 批准人
     */
    private String inboundApprover;
    /**
     * 关闭人
     */
    private String inboundCloser;
    /**
     * 入库单状态
     */
    private String inboundState;
    /**
     * 提交日期
     */
    private Date createDate;
    List<AccessoriesInboundDetailVo> inboundDetailVoList;
}

