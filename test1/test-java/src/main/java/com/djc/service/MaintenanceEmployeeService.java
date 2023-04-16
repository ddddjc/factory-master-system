package com.djc.service;

import com.djc.entity.MaintenanceEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维护安排与员工关系表
 * (MaintenanceEmployee)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:06
 */
public interface MaintenanceEmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param maintenanceEmployeeId 主键
     * @return 实例对象
     */
    MaintenanceEmployee queryById(Integer maintenanceEmployeeId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<MaintenanceEmployee> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param maintenanceEmployee 实例对象
     * @return 实例对象
     */
    MaintenanceEmployee insert(MaintenanceEmployee maintenanceEmployee);

    /**
     * 修改数据
     *
     * @param maintenanceEmployee 实例对象
     * @return 实例对象
     */
    MaintenanceEmployee update(MaintenanceEmployee maintenanceEmployee);

    /**
     * 通过主键删除数据
     *
     * @param maintenanceEmployeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer maintenanceEmployeeId);

}
