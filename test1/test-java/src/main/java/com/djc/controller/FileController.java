package com.djc.controller;

import com.djc.entity.File;
import com.djc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 文件表(File)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("file")
public class FileController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private FileService fileService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<File> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.fileService.queryById(id));
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
    public JsonResult<List<File>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<File>>(200, "查询成功", this.fileService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param file 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<File> add(@RequestBody File file) {
        return new JsonResult<>(200, "新增成功", this.fileService.insert(file));
    }

    /**
     * 编辑数据
     *
     * @param file 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<File> edit(@RequestBody File file) {
        return new JsonResult<>(200, "修改成功", this.fileService.update(file));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.fileService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
