package com.djc.service;

import com.djc.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 员工表(Employee)表服务接口
 *
 * @author djc
 * @since 2023-04-15 13:28:52
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    Employee queryById(Integer employeeId);

    /**
     * 分页查询
     *
     * @param employee    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Employee> queryByPage(Employee employee, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Employee> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);

}
