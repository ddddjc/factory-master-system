package com.djc.controller;

import com.djc.entity.MachineType;
import com.djc.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 机器类型(按种类）
 * (MachineType)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("machineType")
public class MachineTypeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private MachineTypeService machineTypeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<MachineType> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.machineTypeService.queryById(id));
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
    public JsonResult<List<MachineType>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<MachineType>>(200, "查询成功", this.machineTypeService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param machineType 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<MachineType> add(@RequestBody MachineType machineType) {
        return new JsonResult<>(200, "新增成功", this.machineTypeService.insert(machineType));
    }

    /**
     * 编辑数据
     *
     * @param machineType 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<MachineType> edit(@RequestBody MachineType machineType) {
        return new JsonResult<>(200, "修改成功", this.machineTypeService.update(machineType));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.machineTypeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
