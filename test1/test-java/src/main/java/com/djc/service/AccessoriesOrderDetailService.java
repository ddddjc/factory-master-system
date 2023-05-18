package com.djc.service;

import com.djc.entity.AccessoriesOrder;
import com.djc.entity.AccessoriesOrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 到货详情(AccessoriesOrderDetail)表服务接口
 *
 * @author djc
 * @since 2023-05-18 15:17:26
 */
public interface AccessoriesOrderDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderDetailId 主键
     * @return 实例对象
     */
    AccessoriesOrderDetail queryById(Integer orderDetailId);

    /**
     * 分页查询
     *
     * @param accessoriesOrderDetail 筛选条件
     * @param pageRequest            分页对象
     * @return 查询结果
     */
    Page<AccessoriesOrderDetail> queryByPage(AccessoriesOrderDetail accessoriesOrderDetail, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param accessoriesOrderDetail 实例对象
     * @return 实例对象
     */
    AccessoriesOrderDetail insert(AccessoriesOrderDetail accessoriesOrderDetail);

    /**
     * 修改数据
     *
     * @param accessoriesOrderDetail 实例对象
     * @return 实例对象
     */
    AccessoriesOrderDetail update(AccessoriesOrderDetail accessoriesOrderDetail);

    /**
     * 通过主键删除数据
     *
     * @param orderDetailId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderDetailId);

    /**
     * 模糊查询
     * @param accessoriesOrderDetail
     * @param page
     * @param num
     * @return
     */
    List<AccessoriesOrderDetail> queryByLike(AccessoriesOrderDetail accessoriesOrderDetail, Integer page, Integer num);

    Integer queryNumByLike(AccessoriesOrderDetail accessoriesOrderDetail);
}
