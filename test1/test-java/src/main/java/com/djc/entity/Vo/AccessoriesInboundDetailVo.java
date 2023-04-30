package com.djc.entity.Vo;

import com.djc.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: djc
 * @Date: 2023-05-01-1:35
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccessoriesInboundDetailVo {
    private AccessoriesInboundDetail accessoriesInboundDetail;
    private Accessories accessories;
    private Inventory inventory;
    private Depot depot;
}
