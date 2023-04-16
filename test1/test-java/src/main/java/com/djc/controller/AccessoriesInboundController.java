package com.djc.controller;

import com.djc.entity.AccessoriesInbound;
import com.djc.service.AccessoriesInboundService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入库信息(AccessoriesInbound)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("accessoriesInbound")
public class AccessoriesInboundController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesInboundService accessoriesInboundService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesInbound> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesInboundService.queryById(id));
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
    public JsonResult<List<AccessoriesInbound>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<AccessoriesInbound>>(200, "查询成功", this.accessoriesInboundService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesInbound 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesInbound> add(@RequestBody AccessoriesInbound accessoriesInbound) {
        return new JsonResult<>(200, "新增成功", this.accessoriesInboundService.insert(accessoriesInbound));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesInbound 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesInbound> edit(@RequestBody AccessoriesInbound accessoriesInbound) {
        return new JsonResult<>(200, "修改成功", this.accessoriesInboundService.update(accessoriesInbound));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesInboundService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
