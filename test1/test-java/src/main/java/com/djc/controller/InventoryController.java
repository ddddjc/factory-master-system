package com.djc.controller;

import com.djc.entity.Inventory;
import com.djc.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 库存(Inventory)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("inventory")
public class InventoryController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private InventoryService inventoryService;

    /**
     * 分页查询
     *
     * @param inventory   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<Inventory>> queryByPage(Inventory inventory, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.inventoryService.queryByPage(inventory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Inventory> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.inventoryService.queryById(id));
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
    public JsonResult<List<Inventory>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Inventory>>(200, "查询成功", this.inventoryService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param inventory 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Inventory> add(Inventory inventory) {
        return new JsonResult<>(200, "新增成功", this.inventoryService.insert(inventory));
    }

    /**
     * 编辑数据
     *
     * @param inventory 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Inventory> edit(Inventory inventory) {
        return new JsonResult<>(200, "修改成功", this.inventoryService.update(inventory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.inventoryService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
