package com.djc.entity.Vo;

import com.djc.entity.Accessories;
import com.djc.entity.AccessoriesArrivalDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: djc
 * @Date: 2023-04-30-16:46
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccessoriesArrivalDetailVo {
    private AccessoriesArrivalDetail accessoriesArrivalDetail;
    private Accessories accessories;
}
