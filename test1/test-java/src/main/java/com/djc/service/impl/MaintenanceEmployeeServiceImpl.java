package com.djc.service.impl;

import com.djc.entity.MaintenanceEmployee;
import com.djc.mapper.MaintenanceEmployeeMapper;
import com.djc.service.MaintenanceEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维护安排与员工关系表
 * (MaintenanceEmployee)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 13:28:50
 */
@Service("maintenanceEmployeeService")
public class MaintenanceEmployeeServiceImpl implements MaintenanceEmployeeService {
    @Autowired
    private MaintenanceEmployeeMapper maintenanceEmployeeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param maintenanceEmployeeId 主键
     * @return 实例对象
     */
    @Override
    public MaintenanceEmployee queryById(Integer maintenanceEmployeeId) {
        return this.maintenanceEmployeeMapper.queryById(maintenanceEmployeeId);
    }

    /**
     * 分页查询
     *
     * @param maintenanceEmployee 筛选条件
     * @param pageRequest         分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaintenanceEmployee> queryByPage(MaintenanceEmployee maintenanceEmployee, PageRequest pageRequest) {
        long total = this.maintenanceEmployeeMapper.count(maintenanceEmployee);
        return new PageImpl<>(this.maintenanceEmployeeMapper.queryAllByLimit(maintenanceEmployee, pageRequest), pageRequest, total);
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
    public List<MaintenanceEmployee> queryAll(String keyWord, int page, int num) {
        return this.maintenanceEmployeeMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param maintenanceEmployee 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceEmployee insert(MaintenanceEmployee maintenanceEmployee) {
        this.maintenanceEmployeeMapper.insert(maintenanceEmployee);
        return maintenanceEmployee;
    }

    /**
     * 修改数据
     *
     * @param maintenanceEmployee 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceEmployee update(MaintenanceEmployee maintenanceEmployee) {
        this.maintenanceEmployeeMapper.update(maintenanceEmployee);
        return this.queryById(maintenanceEmployee.getMaintenanceEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param maintenanceEmployeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer maintenanceEmployeeId) {
        return this.maintenanceEmployeeMapper.deleteById(maintenanceEmployeeId) > 0;
    }
}
