package com.djc.controller;

import com.djc.entity.AccessoriesOutbound;
import com.djc.service.AccessoriesOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 出库申请（领材料申请单）(AccessoriesOutbound)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("accessoriesOutbound")
public class AccessoriesOutboundController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesOutboundService accessoriesOutboundService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesOutbound> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesOutboundService.queryById(id));
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
    public JsonResult<List<AccessoriesOutbound>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<AccessoriesOutbound>>(200, "查询成功", this.accessoriesOutboundService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesOutbound 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesOutbound> add(@RequestBody AccessoriesOutbound accessoriesOutbound) {
        return new JsonResult<>(200, "新增成功", this.accessoriesOutboundService.insert(accessoriesOutbound));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesOutbound 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesOutbound> edit(@RequestBody AccessoriesOutbound accessoriesOutbound) {
        return new JsonResult<>(200, "修改成功", this.accessoriesOutboundService.update(accessoriesOutbound));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesOutboundService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
