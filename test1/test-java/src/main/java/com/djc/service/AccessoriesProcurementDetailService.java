package com.djc.service;

import com.djc.entity.AccessoriesProcurementDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 申购详情(AccessoriesProcurementDetail)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:08
 */
public interface AccessoriesProcurementDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param procurementDetailId 主键
     * @return 实例对象
     */
    AccessoriesProcurementDetail queryById(Integer procurementDetailId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesProcurementDetail> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesProcurementDetail 实例对象
     * @return 实例对象
     */
    AccessoriesProcurementDetail insert(AccessoriesProcurementDetail accessoriesProcurementDetail);

    /**
     * 修改数据
     *
     * @param accessoriesProcurementDetail 实例对象
     * @return 实例对象
     */
    AccessoriesProcurementDetail update(AccessoriesProcurementDetail accessoriesProcurementDetail);

    /**
     * 通过主键删除数据
     *
     * @param procurementDetailId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer procurementDetailId);

}
