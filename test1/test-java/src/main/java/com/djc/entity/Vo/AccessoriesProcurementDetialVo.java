package com.djc.entity.Vo;

import com.djc.entity.Accessories;
import com.djc.entity.AccessoriesProcurementDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: djc
 * @Date: 2023-04-30-10:48
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccessoriesProcurementDetialVo {
    private AccessoriesProcurementDetail accessoriesProcurementDetail;
    private Accessories accessories;
}
