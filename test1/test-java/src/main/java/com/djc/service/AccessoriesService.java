package com.djc.service;

import com.djc.entity.Accessories;
import com.djc.entity.Vo.AccessoriesVo;

import java.util.List;

/**
 * 配件表
 * (Accessories)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:16
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

    List<Accessories> queryByLimit(Accessories accessories, Integer page, Integer num);

    AccessoriesVo queryVoById(Integer id);
}
