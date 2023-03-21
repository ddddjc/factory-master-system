package com.djc.service;

import com.djc.entity.EmployeeMachine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (EmployeeMachine)表服务接口
 *
 * @author djc
 * @since 2023-03-21 21:59:32
 */
public interface EmployeeMachineService {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    EmployeeMachine queryById(Integer employeeId);

    /**
     * 分页查询
     *
     * @param employeeMachine 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<EmployeeMachine> queryByPage(EmployeeMachine employeeMachine, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<EmployeeMachine> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param employeeMachine 实例对象
     * @return 实例对象
     */
    EmployeeMachine insert(EmployeeMachine employeeMachine);

    /**
     * 修改数据
     *
     * @param employeeMachine 实例对象
     * @return 实例对象
     */
    EmployeeMachine update(EmployeeMachine employeeMachine);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);

}
