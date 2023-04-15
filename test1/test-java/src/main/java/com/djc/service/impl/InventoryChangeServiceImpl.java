package com.djc.service.impl;

import com.djc.entity.InventoryChange;
import com.djc.mapper.InventoryChangeMapper;
import com.djc.service.InventoryChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (InventoryChange)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:28:53
 */
@Service("inventoryChangeService")
public class InventoryChangeServiceImpl implements InventoryChangeService {
    @Autowired
    private InventoryChangeMapper inventoryChangeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param changeId 主键
     * @return 实例对象
     */
    @Override
    public InventoryChange queryById(Integer changeId) {
        return this.inventoryChangeMapper.queryById(changeId);
    }

    /**
     * 分页查询
     *
     * @param inventoryChange 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<InventoryChange> queryByPage(InventoryChange inventoryChange, PageRequest pageRequest) {
        long total = this.inventoryChangeMapper.count(inventoryChange);
        return new PageImpl<>(this.inventoryChangeMapper.queryAllByLimit(inventoryChange, pageRequest), pageRequest, total);
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
    public List<InventoryChange> queryAll(String keyWord, int page, int num) {
        return this.inventoryChangeMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param inventoryChange 实例对象
     * @return 实例对象
     */
    @Override
    public InventoryChange insert(InventoryChange inventoryChange) {
        this.inventoryChangeMapper.insert(inventoryChange);
        return inventoryChange;
    }

    /**
     * 修改数据
     *
     * @param inventoryChange 实例对象
     * @return 实例对象
     */
    @Override
    public InventoryChange update(InventoryChange inventoryChange) {
        this.inventoryChangeMapper.update(inventoryChange);
        return this.queryById(inventoryChange.getChangeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param changeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer changeId) {
        return this.inventoryChangeMapper.deleteById(changeId) > 0;
    }
}
