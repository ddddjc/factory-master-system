package com.djc.service;

import com.djc.entity.AccessoriesType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (AccessoriesType)表服务接口
 *
 * @author djc
 * @since 2023-05-21 15:29:18
 */
public interface AccessoriesTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    AccessoriesType queryById(Integer typeId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesType> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesType 实例对象
     * @return 实例对象
     */
    AccessoriesType insert(AccessoriesType accessoriesType);

    /**
     * 修改数据
     *
     * @param accessoriesType 实例对象
     * @return 实例对象
     */
    AccessoriesType update(AccessoriesType accessoriesType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeId);

}
