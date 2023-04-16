package com.djc.service;

import com.djc.entity.AccessoriesArrival;

import java.util.List;

/**
 * 到货单(AccessoriesArrival)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:15
 */
public interface AccessoriesArrivalService {

    /**
     * 通过ID查询单条数据
     *
     * @param arrivalId 主键
     * @return 实例对象
     */
    AccessoriesArrival queryById(Integer arrivalId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesArrival> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesArrival 实例对象
     * @return 实例对象
     */
    AccessoriesArrival insert(AccessoriesArrival accessoriesArrival);

    /**
     * 修改数据
     *
     * @param accessoriesArrival 实例对象
     * @return 实例对象
     */
    AccessoriesArrival update(AccessoriesArrival accessoriesArrival);

    /**
     * 通过主键删除数据
     *
     * @param arrivalId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer arrivalId);

}
