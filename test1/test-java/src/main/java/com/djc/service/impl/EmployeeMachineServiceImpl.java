package com.djc.service.impl;

import com.djc.entity.EmployeeMachine;
import com.djc.mapper.EmployeeMachineMapper;
import com.djc.service.EmployeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (EmployeeMachine)表服务实现类
 *
 * @author djc
 * @since 2023-03-21 21:59:32
 */
@Service("employeeMachineService")
public class EmployeeMachineServiceImpl implements EmployeeMachineService {
    @Autowired
    private EmployeeMachineMapper employeeMachineMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public EmployeeMachine queryById(Integer employeeId) {
        return this.employeeMachineMapper.queryById(employeeId);
    }

    /**
     * 分页查询
     *
     * @param employeeMachine 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<EmployeeMachine> queryByPage(EmployeeMachine employeeMachine, PageRequest pageRequest) {
        long total = this.employeeMachineMapper.count(employeeMachine);
        return new PageImpl<>(this.employeeMachineMapper.queryAllByLimit(employeeMachine, pageRequest), pageRequest, total);
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
    public List<EmployeeMachine> queryAll(String keyWord, int page, int num) {
        return this.employeeMachineMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param employeeMachine 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeMachine insert(EmployeeMachine employeeMachine) {
        this.employeeMachineMapper.insert(employeeMachine);
        return employeeMachine;
    }

    /**
     * 修改数据
     *
     * @param employeeMachine 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeMachine update(EmployeeMachine employeeMachine) {
        this.employeeMachineMapper.update(employeeMachine);
        return this.queryById(employeeMachine.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.employeeMachineMapper.deleteById(employeeId) > 0;
    }
}
