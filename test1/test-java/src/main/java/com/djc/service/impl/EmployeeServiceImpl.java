package com.djc.service.impl;

import com.djc.entity.Employee;
import com.djc.entity.Permission;
import com.djc.entity.Vo.QueryEmployeeVo;
import com.djc.mapper.EmployeeMapper;
import com.djc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工表(Employee)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:54:58
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public QueryEmployeeVo queryById(Integer employeeId) {
        return this.employeeMapper.queryById(employeeId);
    }

//    /**
//     * 分页查询
//     *
//     * @param employee    筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    @Override
//    public Page<Employee> queryByPage(Employee employee, PageRequest pageRequest) {
//        long total = this.employeeMapper.count(employee);
//        return new PageImpl<>(this.employeeMapper.queryAllByLimit(employee, pageRequest), pageRequest, total);
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @Override
    public List<Employee> queryAll(String keyWord, int page, int num) {
        return this.employeeMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        this.employeeMapper.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public QueryEmployeeVo update(Employee employee) {
        this.employeeMapper.update(employee);
        return this.queryById(employee.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.employeeMapper.deleteById(employeeId) > 0;
    }

    /**
     * 条件查询
     * @param employee
     * @param num
     * @param page
     * @return
     */
    @Override
    public List<QueryEmployeeVo> queryByCondition(Employee employee, Integer num, Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "employeeId"); // 以 id 字段升序排序
        System.out.println(sort.toString());
        PageRequest pageRequest=PageRequest.of(page,num,sort);
        System.out.println(pageRequest.toString());
        List<QueryEmployeeVo> employees=employeeMapper.queryAllByLimit(employee,pageRequest);
        return employees;
    }

    @Override
    public Permission queryPermission(String role) {
        List<String> menus=employeeMapper.selectMenus(role);
        List<String> points=employeeMapper.selectPoints(role);
        Permission permission=new Permission();
        permission.setMenus(menus);
        permission.setPoints(points);
        return permission;
    }

    @Override
    public Integer queryNum(Employee employee) {
        return (int)employeeMapper.count(employee);
    }

    @Override
    public List<QueryEmployeeVo> queryByTeamId(Integer id, int page, Integer num) {
        return employeeMapper.queryByTeam(id,page,num);
    }

}
