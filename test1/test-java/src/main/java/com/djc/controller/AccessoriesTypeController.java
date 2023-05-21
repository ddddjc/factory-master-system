package com.djc.controller;

import com.djc.entity.AccessoriesType;
import com.djc.service.AccessoriesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * (AccessoriesType)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("accessoriesType")
public class AccessoriesTypeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesTypeService accessoriesTypeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesType> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesTypeService.queryById(id));
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
    public JsonResult<List<AccessoriesType>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<AccessoriesType>>(200, "查询成功", this.accessoriesTypeService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesType 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesType> add(@RequestBody AccessoriesType accessoriesType) {
        return new JsonResult<>(200, "新增成功", this.accessoriesTypeService.insert(accessoriesType));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesType 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesType> edit(@RequestBody AccessoriesType accessoriesType) {
        return new JsonResult<>(200, "修改成功", this.accessoriesTypeService.update(accessoriesType));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesTypeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
