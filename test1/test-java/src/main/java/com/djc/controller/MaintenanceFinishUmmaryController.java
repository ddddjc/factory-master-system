package com.djc.controller;

import com.djc.entity.MaintenanceFinishUmmary;
import com.djc.service.MaintenanceFinishUmmaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 维护完成汇总(MaintenanceFinishUmmary)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("maintenanceFinishUmmary")
public class MaintenanceFinishUmmaryController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private MaintenanceFinishUmmaryService maintenanceFinishUmmaryService;

    /**
     * 分页查询
     *
     * @param maintenanceFinishUmmary 筛选条件
     * @param pageRequest             分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<MaintenanceFinishUmmary>> queryByPage(MaintenanceFinishUmmary maintenanceFinishUmmary, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.maintenanceFinishUmmaryService.queryByPage(maintenanceFinishUmmary, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<MaintenanceFinishUmmary> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.maintenanceFinishUmmaryService.queryById(id));
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
    public JsonResult<List<MaintenanceFinishUmmary>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<MaintenanceFinishUmmary>>(200, "查询成功", this.maintenanceFinishUmmaryService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param maintenanceFinishUmmary 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<MaintenanceFinishUmmary> add(@RequestBody MaintenanceFinishUmmary maintenanceFinishUmmary) {
        return new JsonResult<>(200, "新增成功", this.maintenanceFinishUmmaryService.insert(maintenanceFinishUmmary));
    }

    /**
     * 编辑数据
     *
     * @param maintenanceFinishUmmary 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<MaintenanceFinishUmmary> edit(@RequestBody MaintenanceFinishUmmary maintenanceFinishUmmary) {
        return new JsonResult<>(200, "修改成功", this.maintenanceFinishUmmaryService.update(maintenanceFinishUmmary));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.maintenanceFinishUmmaryService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
