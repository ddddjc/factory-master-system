package com.djc.service;

import com.djc.entity.AccessoriesOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 到货单(AccessoriesOrder)表服务接口
 *
 * @author djc
 * @since 2023-05-18 15:17:25
 */
public interface AccessoriesOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    AccessoriesOrder queryById(Integer orderId);

    /**
     * 分页查询
     *
     * @param accessoriesOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<AccessoriesOrder> queryByPage(AccessoriesOrder accessoriesOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param accessoriesOrder 实例对象
     * @return 实例对象
     */
    AccessoriesOrder insert(AccessoriesOrder accessoriesOrder);

    /**
     * 修改数据
     *
     * @param accessoriesOrder 实例对象
     * @return 实例对象
     */
    AccessoriesOrder update(AccessoriesOrder accessoriesOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderId);

    List<AccessoriesOrder> queryByLike(AccessoriesOrder accessoriesOrder, Integer page, Integer num);

    Integer queryNumByLike(AccessoriesOrder accessoriesOrder);
}
