package com.djc.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 到货单(AccessoriesArrival)实体类
 *
 * @author djc
 * @since 2023-04-16 14:02:15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccessoriesArrivalVo implements Serializable {
    private static final long serialVersionUID = -95933074012257583L;
    /**
     * 到货表
     */
    private Integer arrivalId;
    /**
     * 操作人id
     */
    private Integer employeeId;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 单据号
     */
    private String document;
    /**
     * 到货日期
     */
    private Date arrivalDate;
    /**
     * 采购类型
     */

    private String purchaseType;
    /**
     * 品牌
     */
    private String accessoriesBrand;
    /**
     * 供应商
     */
    private String vendor;
    /**
     * 部门
     */
    private String department;
    /**
     * 业务员
     */
    private String clerkName;
    /**
     * 币种
     */
    private String currency;
    /**
     * 汇率
     */
    private String exchangeRate;
    /**
     * 运输方式
     */
    private String transportationType;
    /**
     * 税率
     */
    private String taxRate;
    /**
     * 备注
     */
    private String arrivalRemark;
    /**
     * 发票号
     */
    private String invoiceNumber;
    /**
     * 制单人
     */
    private String arrivalCreater;
    /**
     * 现存量
     */
    private Integer nowNum;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 到货到状态
     */
    private String arrivalState;
    /**
     * 记录日期
     */
    private Date createDate;

    private List<AccessoriesArrivalDetailVo> detailList;
}

