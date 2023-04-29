package com.djc.controller;

import com.djc.entity.MaintenanceArrange;
import com.djc.entity.MaintenanceEmployee;
import com.djc.exception.CustomException;
import com.djc.service.MaintenanceArrangeService;
import com.djc.service.MaintenanceEmployeeService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 维护（保养）安排表(MaintenanceArrange)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("maintenanceArrange")
public class MaintenanceArrangeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private MaintenanceArrangeService maintenanceArrangeService;
    @Autowired
    private MaintenanceEmployeeService maintenanceEmployeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult queryByVoId(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.maintenanceArrangeService.queryVoById(id));
    }

    @GetMapping()
    public JsonResult queryByLike(MaintenanceArrange maintenanceArrange ,@Param("page") Integer page,@Param("num")Integer num){
        List list=maintenanceArrangeService.queryByLike(maintenanceArrange,page-1,num);
        Integer total=maintenanceArrangeService.LikeNum(maintenanceArrange);
        Map map=new HashMap();
        map.put("maintenanceArrangeList",list);
        map.put("total",total);
        return new JsonResult(200,"查询成功",map);
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
    public JsonResult<List<MaintenanceArrange>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<MaintenanceArrange>>(200, "查询成功", this.maintenanceArrangeService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param maintenanceArrange 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<MaintenanceArrange> add(@RequestBody MaintenanceArrange maintenanceArrange) {
        return new JsonResult<>(200, "新增成功", this.maintenanceArrangeService.insert(maintenanceArrange));
    }

    /**
     * 编辑数据
     *
     * @param maintenanceArrange 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<MaintenanceArrange> edit(@RequestBody MaintenanceArrange maintenanceArrange) {
        return new JsonResult<>(200, "修改成功", this.maintenanceArrangeService.update(maintenanceArrange));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.maintenanceArrangeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 给维护计划添加员工
     * @param maintenanceEmployee
     * @return
     */
    @PutMapping("addEmployee")
    public JsonResult addEmployee(MaintenanceEmployee maintenanceEmployee){
        if (maintenanceEmployee.getMaintenanceArrangeId()==null||maintenanceEmployee.getEmployeeId()==null) throw new CustomException(4001,"请输入EmployeeId和MaintenanceArrangeId");
        maintenanceEmployeeService.insert(maintenanceEmployee);
        return new JsonResult(200,"添加成功",maintenanceArrangeService.queryVoById(maintenanceEmployee.getMaintenanceArrangeId()));
    }
    @DeleteMapping("delEmployee/{maintenanceEmployeeId}")
    public JsonResult delEmployee(@PathVariable("maintenanceEmployeeId")Integer maintenanceEmployeeId){
        MaintenanceEmployee maintenanceEmployee = maintenanceEmployeeService.queryById(maintenanceEmployeeId);
        if (maintenanceEmployee==null) return new JsonResult(200,"该用户不存在");
        maintenanceEmployeeService.deleteById(maintenanceEmployeeId);
        return new JsonResult(200,"删除成功",maintenanceArrangeService.queryVoById(maintenanceEmployee.getMaintenanceArrangeId()));
    }
}
