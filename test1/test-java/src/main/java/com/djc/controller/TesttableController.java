package com.djc.controller;

import com.djc.entity.Testtable;
import com.djc.service.TesttableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * (Testtable)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("testtable")
public class TesttableController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private TesttableService testtableService;

    /**
     * 分页查询
     *
     * @param testtable   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<Testtable>> queryByPage(Testtable testtable, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.testtableService.queryByPage(testtable, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Testtable> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.testtableService.queryById(id));
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
    public JsonResult<List<Testtable>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Testtable>>(200, "查询成功", this.testtableService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param testtable 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Testtable> add(@RequestBody Testtable testtable) {
        return new JsonResult<>(200, "新增成功", this.testtableService.insert(testtable));
    }

    /**
     * 编辑数据
     *
     * @param testtable 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Testtable> edit(@RequestBody Testtable testtable) {
        return new JsonResult<>(200, "修改成功", this.testtableService.update(testtable));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.testtableService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
