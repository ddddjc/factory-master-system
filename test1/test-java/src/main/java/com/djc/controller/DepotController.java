package com.djc.controller;

import com.djc.entity.Depot;
import com.djc.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 仓库信息
 * (Depot)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("depot")
public class DepotController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private DepotService depotService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Depot> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.depotService.queryById(id));
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
    public JsonResult<List<Depot>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Depot>>(200, "查询成功", this.depotService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param depot 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Depot> add(@RequestBody Depot depot) {
        return new JsonResult<>(200, "新增成功", this.depotService.insert(depot));
    }

    /**
     * 编辑数据
     *
     * @param depot 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Depot> edit(@RequestBody Depot depot) {
        return new JsonResult<>(200, "修改成功", this.depotService.update(depot));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.depotService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
