package com.djc.service.impl;

import com.djc.entity.Permissions;
import com.djc.mapper.PermissionsMapper;
import com.djc.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 权限表(Permissions)表服务实现类
 *
 * @author djc
 * @since 2023-03-19 19:14:22
 */
@Service("permissionsService")
public class PermissionsServiceImpl implements PermissionsService {
    @Autowired
    private PermissionsMapper permissionsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Permissions queryById(Integer id) {
        return this.permissionsMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param permissions 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Permissions> queryByPage(Permissions permissions, PageRequest pageRequest) {
        long total = this.permissionsMapper.count(permissions);
        return new PageImpl<>(this.permissionsMapper.queryAllByLimit(permissions, pageRequest), pageRequest, total);
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
    public List<Permissions> queryAll(String keyWord, int page, int num) {
        return this.permissionsMapper.queryAll(keyWord, page, num);
    }

    /**
     * 新增数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    @Override
    public Permissions insert(Permissions permissions) {
        this.permissionsMapper.insert(permissions);
        return permissions;
    }

    /**
     * 修改数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    @Override
    public Permissions update(Permissions permissions) {
        this.permissionsMapper.update(permissions);
        return this.queryById(permissions.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.permissionsMapper.deleteById(id) > 0;
    }
}
