package com.djc.service;

import com.djc.entity.Employee;
import com.djc.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 小组表(Group)表服务接口
 *
 * @author djc
 * @since 2023-03-19 19:14:21
 */
public interface GroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param groupId 主键
     * @return 实例对象
     */
    Group queryById(Integer groupId);

    /**
     * 分页查询
     *
     * @param group       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Group> queryByPage(Group group, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Group> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param group 实例对象
     * @return 实例对象
     */
    Group insert(Group group);

    /**
     * 修改数据
     *
     * @param group 实例对象
     * @return 实例对象
     */
    Group update(Group group);

    /**
     * 通过主键删除数据
     *
     * @param groupId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer groupId);

    List<Employee> findEmployee(Integer groupId);

    void deletcEmployee(Integer groupId, Integer employeeId);
}
