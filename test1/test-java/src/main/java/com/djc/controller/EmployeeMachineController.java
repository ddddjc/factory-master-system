package com.djc.controller;

import com.djc.entity.EmployeeMachine;
import com.djc.service.EmployeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * (EmployeeMachine)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("employeeMachine")
public class EmployeeMachineController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private EmployeeMachineService employeeMachineService;

    /**
     * 分页查询
     *
     * @param employeeMachine 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<EmployeeMachine>> queryByPage(EmployeeMachine employeeMachine, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.employeeMachineService.queryByPage(employeeMachine, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<EmployeeMachine> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.employeeMachineService.queryById(id));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyword 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @GetMapping("/findAll")
    public JsonResult<List<EmployeeMachine>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<EmployeeMachine>>(200, "查询成功", this.employeeMachineService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param employeeMachine 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<EmployeeMachine> add(EmployeeMachine employeeMachine) {
        return new JsonResult<>(200, "新增成功", this.employeeMachineService.insert(employeeMachine));
    }

    /**
     * 编辑数据
     *
     * @param employeeMachine 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<EmployeeMachine> edit(EmployeeMachine employeeMachine) {
        return new JsonResult<>(200, "修改成功", this.employeeMachineService.update(employeeMachine));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.employeeMachineService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
