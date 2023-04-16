package com.djc.controller;

import com.djc.entity.InventoryChange;
import com.djc.service.InventoryChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * (InventoryChange)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("inventoryChange")
public class InventoryChangeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private InventoryChangeService inventoryChangeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<InventoryChange> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.inventoryChangeService.queryById(id));
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
    public JsonResult<List<InventoryChange>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<InventoryChange>>(200, "查询成功", this.inventoryChangeService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param inventoryChange 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<InventoryChange> add(@RequestBody InventoryChange inventoryChange) {
        return new JsonResult<>(200, "新增成功", this.inventoryChangeService.insert(inventoryChange));
    }

    /**
     * 编辑数据
     *
     * @param inventoryChange 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<InventoryChange> edit(@RequestBody InventoryChange inventoryChange) {
        return new JsonResult<>(200, "修改成功", this.inventoryChangeService.update(inventoryChange));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.inventoryChangeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
