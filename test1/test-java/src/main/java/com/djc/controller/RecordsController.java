package com.djc.controller;

import com.djc.entity.Records;
import com.djc.service.RecordsService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 维修(维修)记录表
 * (Records)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("records")
public class RecordsController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private RecordsService recordsService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Records> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.recordsService.queryById(id));
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
    public JsonResult<List<Records>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Records>>(200, "查询成功", this.recordsService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param records 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Records> add(@RequestBody Records records) {
        return new JsonResult<>(200, "新增成功", this.recordsService.insert(records));
    }

    /**
     * 编辑数据
     *
     * @param records 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Records> edit(@RequestBody Records records) {
        return new JsonResult<>(200, "修改成功", this.recordsService.update(records));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.recordsService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 上传文件
     * @param file
     * @param recordsId
     * @return
     */
    @Value("${file.path}")
    private String fileLocation;
    @PostMapping("/file")
    public JsonResult addfile(@RequestPart("file")MultipartFile file, @Param("recordsId")Integer recordsId) throws IOException {
        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File(fileLocation+ file.getOriginalFilename()));
        return null;
    }
}
