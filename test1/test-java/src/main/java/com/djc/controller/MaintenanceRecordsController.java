package com.djc.controller;

import com.djc.entity.MaintenanceRecords;
import com.djc.service.MaintenanceRecordsService;
import com.djc.util.JsonResult;
import com.djc.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

/**
 * 维修记录表
 * (MaintenanceRecords)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("maintenanceRecords")
public class MaintenanceRecordsController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private MaintenanceRecordsService maintenanceRecordsService;
    /**
     * 分页查询
     *掉分车队参加
     * @param maintenanceRecords 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    @GetMapping
    public JsonResult<Page<MaintenanceRecords>> queryByPage(MaintenanceRecords maintenanceRecords, PageRequest pageRequest) {
        return new JsonResult<>(200, "查询成功", this.maintenanceRecordsService.queryByPage(maintenanceRecords, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<MaintenanceRecords> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.maintenanceRecordsService.queryById(id));
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
    public JsonResult<List<MaintenanceRecords>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<MaintenanceRecords>>(200, "查询成功", this.maintenanceRecordsService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param maintenanceRecords 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<MaintenanceRecords> add(@RequestBody MaintenanceRecords maintenanceRecords) {
        return new JsonResult<>(200, "新增成功", this.maintenanceRecordsService.insert(maintenanceRecords));
    }

    /**
     * 编辑数据
     *
     * @param maintenanceRecords 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<MaintenanceRecords> edit(@RequestBody MaintenanceRecords maintenanceRecords) {
        return new JsonResult<>(200, "修改成功", this.maintenanceRecordsService.update(maintenanceRecords));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.maintenanceRecordsService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
    @GetMapping("/findRecord/employee/{employeeName}")
    public JsonResult findRecordByEmployee(@PathVariable("employeeName") String name, @Param("num") Integer num,@Param("page") Integer page){
        List<MaintenanceRecords> list=maintenanceRecordsService.queryByEmployeeName(name,page,num);
        return new JsonResult(200,"查询成功",list);
    }
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/file")
    public JsonResult uploadFile(@RequestPart("file") MultipartFile file,@RequestPart("recordsId") Integer recordsId ,HttpServletRequest request) throws IOException {
        maintenanceRecordsService.uploadFile(file,recordsId);
        return new JsonResult(200,"上传成功",null);
    }
    @GetMapping("/file")
    public JsonResult findFile(@Param("type") String type,@Param("recoedId") Integer recoedId){
        List<String> strings=maintenanceRecordsService.findFile(type,recoedId);
        return new JsonResult(200,"查询成功",strings);
    }

}
