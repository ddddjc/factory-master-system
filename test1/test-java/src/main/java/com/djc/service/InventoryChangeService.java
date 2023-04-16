package com.djc.service;

import com.djc.entity.InventoryChange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (InventoryChange)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:15
 */
public interface InventoryChangeService {

    /**
     * 通过ID查询单条数据
     *
     * @param changeId 主键
     * @return 实例对象
     */
    InventoryChange queryById(Integer changeId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<InventoryChange> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param inventoryChange 实例对象
     * @return 实例对象
     */
    InventoryChange insert(InventoryChange inventoryChange);

    /**
     * 修改数据
     *
     * @param inventoryChange 实例对象
     * @return 实例对象
     */
    InventoryChange update(InventoryChange inventoryChange);

    /**
     * 通过主键删除数据
     *
     * @param changeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer changeId);

}
