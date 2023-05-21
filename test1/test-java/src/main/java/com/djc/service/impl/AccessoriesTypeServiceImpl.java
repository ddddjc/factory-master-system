package com.djc.service.impl;

import com.djc.entity.AccessoriesType;
import com.djc.mapper.AccessoriesTypeMapper;
import com.djc.service.AccessoriesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (AccessoriesType)表服务实现类
 *
 * @author djc
 * @since 2023-05-21 15:29:18
 */
@Service("accessoriesTypeService")
public class AccessoriesTypeServiceImpl implements AccessoriesTypeService {
    @Autowired
    private AccessoriesTypeMapper accessoriesTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesType queryById(Integer typeId) {
        return this.accessoriesTypeMapper.queryById(typeId);
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
    public List<AccessoriesType> queryAll(String keyWord, int page, int num) {
        return this.accessoriesTypeMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesType 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesType insert(AccessoriesType accessoriesType) {
        this.accessoriesTypeMapper.insert(accessoriesType);
        return accessoriesType;
    }

    /**
     * 修改数据
     *
     * @param accessoriesType 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesType update(AccessoriesType accessoriesType) {
        this.accessoriesTypeMapper.update(accessoriesType);
        return this.queryById(accessoriesType.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeId) {
        return this.accessoriesTypeMapper.deleteById(typeId) > 0;
    }
}
