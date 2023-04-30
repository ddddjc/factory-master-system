package com.djc.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-04-30-10:49
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccessoriesProcurementVo {
    private String procurementApprover;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 业务员
     */
    private String clerkName;
    /**
     * 提交日期
     */
    private OffsetDateTime createDate;
    /**
     * 币种
     */
    private String currency;
    /**
     * 部门
     */
    private String department;
    private List<AccessoriesProcurementDetialVo> detailList;
    /**
     * 编号
     */
    private String document;
    /**
     * 操作人id
     */
    private Integer employeeId;
    /**
     * 汇率
     */
    private String exchangeRate;
    /**
     * 发票号
     */
    private String invoiceNumber;
    /**
     * 现存量
     */
    private Integer nowNumber;
    /**
     * 付款条件
     */
    private String paymentTerms;
    /**
     * 变更人
     */
    private String procurementChanger;
    /**
     * 制单人
     */
    private String procurementCreater;
    /**
     * 订单日期
     */
    private OffsetDateTime procurementDate;
    /**
     * 采购id
     */
    private Integer procurementId;
    /**
     * 审核人
     */
    private String procurementReviewer;
    /**
     * 申购单状态
     */
    private String procurementState;
    /**
     * 采购类型
     */
    private String purchaseType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 税率
     */
    private String taxRate;
    /**
     * 供应商
     */
    private String vendor;
}

