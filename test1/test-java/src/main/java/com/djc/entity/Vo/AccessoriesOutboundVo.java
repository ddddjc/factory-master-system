package com.djc.entity.Vo;

import com.djc.entity.AccessoriesOutboundDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-04-30-23:59
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccessoriesOutboundVo {
    /**
     * 出库id
     */
    private Integer outboundId;
    /**
     * 操作人Id
     */
    private Integer employeeId;
    /**
     * 单据号
     */
    private String document;
    /**
     * 日期
     */
    private Date outboundDate;
    /**
     * 业务员
     */
    private String clerkName;
    /**
     * 出库类别
     */
    private String outboudType;
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
    private String outboundRemark;
    /**
     * 制单人
     */
    private String outboundCreater;
    /**
     * 审核人
     */
    private String outboundReviewer;
    /**
     * 批准人
     */
    private String outboundApprover;
    /**
     * 关闭人
     */
    private String outboundCloser;
    /**
     * 出库单状态
     */
    private String outboundState;
    /**
     * 提交日期
     */
    private Date createDate;

    /**
     * 出库详情集合
     */
    private List<AccessoriesOutboundDetail> outboundList;
}
