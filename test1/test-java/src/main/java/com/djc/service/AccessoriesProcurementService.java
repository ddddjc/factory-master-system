package com.djc.service;

import com.djc.entity.AccessoriesProcurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 采购信息(AccessoriesProcurement)表服务接口
 *
 * @author djc
 * @since 2023-04-15 13:28:53
 */
public interface AccessoriesProcurementService {

    /**
     * 通过ID查询单条数据
     *
     * @param procurementId 主键
     * @return 实例对象
     */
    AccessoriesProcurement queryById(Integer procurementId);

    /**
     * 分页查询
     *
     * @param accessoriesProcurement 筛选条件
     * @param pageRequest            分页对象
     * @return 查询结果
     */
    Page<AccessoriesProcurement> queryByPage(AccessoriesProcurement accessoriesProcurement, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesProcurement> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesProcurement 实例对象
     * @return 实例对象
     */
    AccessoriesProcurement insert(AccessoriesProcurement accessoriesProcurement);

    /**
     * 修改数据
     *
     * @param accessoriesProcurement 实例对象
     * @return 实例对象
     */
    AccessoriesProcurement update(AccessoriesProcurement accessoriesProcurement);

    /**
     * 通过主键删除数据
     *
     * @param procurementId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer procurementId);

}
