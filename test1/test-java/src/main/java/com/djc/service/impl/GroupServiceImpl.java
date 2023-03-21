package com.djc.service.impl;

import com.djc.entity.Employee;
import com.djc.entity.Group;
import com.djc.mapper.GroupMapper;
import com.djc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 小组表(Group)表服务实现类
 *
 * @author djc
 * @since 2023-03-19 19:14:21
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param groupId 主键
     * @return 实例对象
     */
    @Override
    public Group queryById(Integer groupId) {
        return this.groupMapper.queryById(groupId);
    }

    /**
     * 分页查询
     *
     * @param group       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Group> queryByPage(Group group, PageRequest pageRequest) {
        long total = this.groupMapper.count(group);
        return new PageImpl<>(this.groupMapper.queryAllByLimit(group, pageRequest), pageRequest, total);
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
    public List<Group> queryAll(String keyWord, int page, int num) {
        return this.groupMapper.queryAll(keyWord, (page-1)*num, num);
    }

    /**
     * 新增数据
     *
     * @param group 实例对象
     * @return 实例对象
     */
    @Override
    public Group insert(Group group) {
        this.groupMapper.insert(group);
        return group;
    }

    /**
     * 修改数据
     *
     * @param group 实例对象
     * @return 实例对象
     */
    @Override
    public Group update(Group group) {
        this.groupMapper.update(group);
        return this.queryById(group.getGroupId());
    }

    /**
     * 通过主键删除数据
     *
     * @param groupId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer groupId) {
        return this.groupMapper.deleteById(groupId) > 0;
    }

    @Override
    public List<Employee> findEmployee(Integer groupId) {
        return groupMapper.findEmployee(groupId);
    }

    @Override
    public void deletcEmployee(Integer groupId, Integer employeeId) {
        groupMapper.deleteEmployee(groupId,employeeId);
    }

}
