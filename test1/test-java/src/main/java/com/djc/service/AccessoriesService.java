package com.djc.service;

import com.djc.entity.Accessories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 配件表
 * (Accessories)表服务接口
 *
 * @author djc
 * @since 2023-03-21 21:31:15
 */
public interface AccessoriesService {

    /**
     * 通过ID查询单条数据
     *
     * @param accessoriesId 主键
     * @return 实例对象
     */
    Accessories queryById(Integer accessoriesId);

    /**
     * 分页查询
     *
     * @param accessories 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Accessories> queryByPage(Accessories accessories, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Accessories> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessories 实例对象
     * @return 实例对象
     */
    Accessories insert(Accessories accessories);

    /**
     * 修改数据
     *
     * @param accessories 实例对象
     * @return 实例对象
     */
    Accessories update(Accessories accessories);

    /**
     * 通过主键删除数据
     *
     * @param accessoriesId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer accessoriesId);

    List<Accessories> findByMachineType(Integer machineTypeId);
}
