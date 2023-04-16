package com.djc.controller;

import com.djc.entity.MaintenanceEmployee;
import com.djc.service.MaintenanceEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 维护安排与员工关系表
 * (MaintenanceEmployee)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("maintenanceEmployee")
public class MaintenanceEmployeeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private MaintenanceEmployeeService maintenanceEmployeeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<MaintenanceEmployee> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.maintenanceEmployeeService.queryById(id));
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
    public JsonResult<List<MaintenanceEmployee>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<MaintenanceEmployee>>(200, "查询成功", this.maintenanceEmployeeService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param maintenanceEmployee 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<MaintenanceEmployee> add(@RequestBody MaintenanceEmployee maintenanceEmployee) {
        return new JsonResult<>(200, "新增成功", this.maintenanceEmployeeService.insert(maintenanceEmployee));
    }

    /**
     * 编辑数据
     *
     * @param maintenanceEmployee 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<MaintenanceEmployee> edit(@RequestBody MaintenanceEmployee maintenanceEmployee) {
        return new JsonResult<>(200, "修改成功", this.maintenanceEmployeeService.update(maintenanceEmployee));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.maintenanceEmployeeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
