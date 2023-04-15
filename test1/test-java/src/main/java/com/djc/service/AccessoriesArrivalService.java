package com.djc.service;

import com.djc.entity.AccessoriesArrival;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 到货单(AccessoriesArrival)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:55:10
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
     * 分页查询
     *
     * @param accessoriesArrival 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    Page<AccessoriesArrival> queryByPage(AccessoriesArrival accessoriesArrival, PageRequest pageRequest);

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
