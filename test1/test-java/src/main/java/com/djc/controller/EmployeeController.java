package com.djc.controller;

import com.djc.entity.Employee;
import com.djc.entity.MyList;
import com.djc.service.EmployeeService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工表(Employee)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("user")
public class EmployeeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * 分页查询
     *
     * @param employee    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<Employee>> queryByPage(Employee employee, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.employeeService.queryByPage(employee, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("findUser/{id}")
    public JsonResult<Employee> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.employeeService.queryById(id));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyword 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @GetMapping("/findAllUser")
    public JsonResult<List<Employee>> findAll(String keyword, int page, int num) {
        System.out.println(keyword);
        System.out.println(page);
        System.out.println(num);
        return new JsonResult<List<Employee>>(200, "查询成功", this.employeeService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param employee 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Employee> add(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        return new JsonResult<>(200, "新增成功", this.employeeService.insert(employee));
    }

    /**
     * 编辑数据
     *
     * @param employee 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Employee> edit(Employee employee) {
        return new JsonResult<>(200, "修改成功", this.employeeService.update(employee));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.employeeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
    @PutMapping("setgroup")
    public JsonResult setgroup(@RequestBody Employee employee){
        Employee employee1=new Employee();
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setGroupId(employee.getGroupId());
        employeeService.update(employee1);
        return new JsonResult(200,"设置修改",null);
    }
    @PostMapping("/addSome")
    public JsonResult addSome(@RequestBody MyList<Employee> myList){
        List list=myList.getList();
        for (Object o: list) {
            Employee e= (Employee) o;
            employeeService.insert(e);
        }
        return new JsonResult(200,"添加成功",null);
    }
}
