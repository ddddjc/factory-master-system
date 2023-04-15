package com.djc.service.impl;

import com.djc.entity.EmployeeDuty;
import com.djc.mapper.EmployeeDutyMapper;
import com.djc.service.EmployeeDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 小组值班分工(EmployeeDuty)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:29:01
 */
@Service("employeeDutyService")
public class EmployeeDutyServiceImpl implements EmployeeDutyService {
    @Autowired
    private EmployeeDutyMapper employeeDutyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param dutyId 主键
     * @return 实例对象
     */
    @Override
    public EmployeeDuty queryById(Integer dutyId) {
        return this.employeeDutyMapper.queryById(dutyId);
    }

    /**
     * 分页查询
     *
     * @param employeeDuty 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<EmployeeDuty> queryByPage(EmployeeDuty employeeDuty, PageRequest pageRequest) {
        long total = this.employeeDutyMapper.count(employeeDuty);
        return new PageImpl<>(this.employeeDutyMapper.queryAllByLimit(employeeDuty, pageRequest), pageRequest, total);
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
    public List<EmployeeDuty> queryAll(String keyWord, int page, int num) {
        return this.employeeDutyMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeDuty insert(EmployeeDuty employeeDuty) {
        this.employeeDutyMapper.insert(employeeDuty);
        return employeeDuty;
    }

    /**
     * 修改数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeDuty update(EmployeeDuty employeeDuty) {
        this.employeeDutyMapper.update(employeeDuty);
        return this.queryById(employeeDuty.getDutyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dutyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer dutyId) {
        return this.employeeDutyMapper.deleteById(dutyId) > 0;
    }
}
