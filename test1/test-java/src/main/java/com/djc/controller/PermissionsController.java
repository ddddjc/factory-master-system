package com.djc.controller;

import com.djc.entity.Permissions;
import com.djc.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 权限表(Permissions)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("permissions")
public class PermissionsController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private PermissionsService permissionsService;

    /**
     * 分页查询
     *
     * @param permissions 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<Permissions>> queryByPage(Permissions permissions, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.permissionsService.queryByPage(permissions, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Permissions> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.permissionsService.queryById(id));
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
    public JsonResult<List<Permissions>> findAll(String keyWord, int page, int num) {
        return new JsonResult<List<Permissions>>(200, "查询成功", this.permissionsService.queryAll(keyWord, page, num));
    }

    /**
     * 新增数据
     *
     * @param permissions 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Permissions> add(Permissions permissions) {
        return new JsonResult<>(200, "新增成功", this.permissionsService.insert(permissions));
    }

    /**
     * 编辑数据
     *
     * @param permissions 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Permissions> edit(Permissions permissions) {
        return new JsonResult<>(200, "修改成功", this.permissionsService.update(permissions));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.permissionsService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
