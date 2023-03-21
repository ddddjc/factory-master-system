package com.djc.service.impl;

import com.djc.entity.Accessories;
import com.djc.mapper.AccessoriesMapper;
import com.djc.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 配件表
 * (Accessories)表服务实现类
 *
 * @author djc
 * @since 2023-03-21 21:31:16
 */
@Service("accessoriesService")
public class AccessoriesServiceImpl implements AccessoriesService {
    @Autowired
    private AccessoriesMapper accessoriesMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param accessoriesId 主键
     * @return 实例对象
     */
    @Override
    public Accessories queryById(Integer accessoriesId) {
        return this.accessoriesMapper.queryById(accessoriesId);
    }

    /**
     * 分页查询
     *
     * @param accessories 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Accessories> queryByPage(Accessories accessories, PageRequest pageRequest) {
        long total = this.accessoriesMapper.count(accessories);
        return new PageImpl<>(this.accessoriesMapper.queryAllByLimit(accessories, pageRequest), pageRequest, total);
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
    public List<Accessories> queryAll(String keyWord, int page, int num) {
        return this.accessoriesMapper.queryAll(keyWord, page, num);
    }

    /**
     * 新增数据
     *
     * @param accessories 实例对象
     * @return 实例对象
     */
    @Override
    public Accessories insert(Accessories accessories) {
        this.accessoriesMapper.insert(accessories);
        return accessories;
    }

    /**
     * 修改数据
     *
     * @param accessories 实例对象
     * @return 实例对象
     */
    @Override
    public Accessories update(Accessories accessories) {
        this.accessoriesMapper.update(accessories);
        return this.queryById(accessories.getAccessoriesId());
    }

    /**
     * 通过主键删除数据
     *
     * @param accessoriesId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer accessoriesId) {
        return this.accessoriesMapper.deleteById(accessoriesId) > 0;
    }

    @Override
    public List<Accessories> findByMachineType(Integer machineTypeId) {
        return accessoriesMapper.findByMachineType(machineTypeId);
    }
}
