package com.djc.service;

import com.djc.entity.EmployeeDuty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 小组值班分工(EmployeeDuty)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:29:01
 */
public interface EmployeeDutyService {

    /**
     * 通过ID查询单条数据
     *
     * @param dutyId 主键
     * @return 实例对象
     */
    EmployeeDuty queryById(Integer dutyId);

    /**
     * 分页查询
     *
     * @param employeeDuty 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<EmployeeDuty> queryByPage(EmployeeDuty employeeDuty, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<EmployeeDuty> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    EmployeeDuty insert(EmployeeDuty employeeDuty);

    /**
     * 修改数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    EmployeeDuty update(EmployeeDuty employeeDuty);

    /**
     * 通过主键删除数据
     *
     * @param dutyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer dutyId);

}
