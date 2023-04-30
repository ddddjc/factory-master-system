package com.djc.service;

import com.djc.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 库存(Inventory)表服务接口
 *
 * @author djc
 * @since 2023-04-30 23:06:17
 */
public interface InventoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param inventoryId 主键
     * @return 实例对象
     */
    Inventory queryById(Integer inventoryId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Inventory> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    Inventory insert(Inventory inventory);

    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    Inventory update(Inventory inventory);

    /**
     * 通过主键删除数据
     *
     * @param inventoryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer inventoryId);

}
