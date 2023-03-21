package com.djc.service;

import com.djc.entity.Permissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 权限表(Permissions)表服务接口
 *
 * @author djc
 * @since 2023-03-21 21:59:31
 */
public interface PermissionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permissions queryById(Integer id);

    /**
     * 分页查询
     *
     * @param permissions 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Permissions> queryByPage(Permissions permissions, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Permissions> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    Permissions insert(Permissions permissions);

    /**
     * 修改数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    Permissions update(Permissions permissions);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
