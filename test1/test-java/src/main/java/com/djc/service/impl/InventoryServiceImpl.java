package com.djc.service.impl;

import com.djc.entity.Inventory;
import com.djc.mapper.InventoryMapper;
import com.djc.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 库存(Inventory)表服务实现类
 *
 * @author djc
 * @since 2023-04-30 23:06:17
 */
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param inventoryId 主键
     * @return 实例对象
     */
    @Override
    public Inventory queryById(Integer inventoryId) {
        return this.inventoryMapper.queryById(inventoryId);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @Override
    public List<Inventory> queryAll(String keyWord, int page, int num) {
        return this.inventoryMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    @Override
    public Inventory insert(Inventory inventory) {
        this.inventoryMapper.insert(inventory);
        return inventory;
    }

    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    @Override
    public Inventory update(Inventory inventory) {
        this.inventoryMapper.update(inventory);
        return this.queryById(inventory.getInventoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param inventoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer inventoryId) {
        return this.inventoryMapper.deleteById(inventoryId) > 0;
    }
}
