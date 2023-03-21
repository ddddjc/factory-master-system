package com.djc.controller;

import com.djc.entity.Accessories;
import com.djc.service.AccessoriesService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 配件表
 * (Accessories)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("accessories")
public class AccessoriesController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesService accessoriesService;

    /**
     * 分页查询
     *
     * @param accessories 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<Accessories>> queryByPage(Accessories accessories, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.accessoriesService.queryByPage(accessories, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Accessories> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesService.queryById(id));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @GetMapping("/findAll")
    public JsonResult<List<Accessories>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Accessories>>(200, "查询成功", this.accessoriesService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessories 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Accessories> add(Accessories accessories) {
        return new JsonResult<>(200, "新增成功", this.accessoriesService.insert(accessories));
    }

    /**
     * 编辑数据
     *
     * @param accessories 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Accessories> edit(Accessories accessories) {
        return new JsonResult<>(200, "修改成功", this.accessoriesService.update(accessories));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
