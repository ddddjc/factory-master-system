package com.djc.entity.Vo;

import com.djc.entity.Accessories;
import com.djc.entity.AccessoriesOutboundDetail;
import com.djc.entity.Depot;
import com.djc.entity.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: djc
 * @Date: 2023-04-30-22:50
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccessoriesOutboundDetailVo {
    private Depot depot;
    private Inventory inventory;
    private Accessories accessories;
    private AccessoriesOutboundDetail outboundDetail;
}
