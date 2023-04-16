package com.djc.controller;

import com.djc.entity.AccessoriesArrivalDetail;
import com.djc.service.AccessoriesArrivalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 到货详情(AccessoriesArrivalDetail)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("accessoriesArrivalDetail")
public class AccessoriesArrivalDetailController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesArrivalDetailService accessoriesArrivalDetailService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesArrivalDetail> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesArrivalDetailService.queryById(id));
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
    public JsonResult<List<AccessoriesArrivalDetail>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<AccessoriesArrivalDetail>>(200, "查询成功", this.accessoriesArrivalDetailService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesArrivalDetail 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesArrivalDetail> add(@RequestBody AccessoriesArrivalDetail accessoriesArrivalDetail) {
        return new JsonResult<>(200, "新增成功", this.accessoriesArrivalDetailService.insert(accessoriesArrivalDetail));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesArrivalDetail 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesArrivalDetail> edit(@RequestBody AccessoriesArrivalDetail accessoriesArrivalDetail) {
        return new JsonResult<>(200, "修改成功", this.accessoriesArrivalDetailService.update(accessoriesArrivalDetail));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesArrivalDetailService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
