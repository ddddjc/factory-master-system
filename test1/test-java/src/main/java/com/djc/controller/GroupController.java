package com.djc.controller;

import com.djc.entity.Group;
import com.djc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 小组表(Group)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("group")
public class GroupController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private GroupService groupService;

    /**
     * 分页查询
     *
     * @param group       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<Group>> queryByPage(Group group, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.groupService.queryByPage(group, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Group> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.groupService.queryById(id));
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
    public JsonResult<List<Group>> findAll(String keyWord, int page, int num) {
        return new JsonResult<List<Group>>(200, "查询成功", this.groupService.queryAll(keyWord, page, num));
    }

    /**
     * 新增数据
     *
     * @param group 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Group> add(Group group) {
        return new JsonResult<>(200, "新增成功", this.groupService.insert(group));
    }

    /**
     * 编辑数据
     *
     * @param group 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Group> edit(Group group) {
        return new JsonResult<>(200, "修改成功", this.groupService.update(group));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.groupService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}