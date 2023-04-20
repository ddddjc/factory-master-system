package com.djc.controller;

import com.djc.entity.Machine;
import com.djc.exception.CustomException;
import com.djc.service.MachineService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备表(具体到台)(Machine)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("machine")
public class MachineController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private MachineService machineService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<Machine> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.machineService.queryById(id));
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
    public JsonResult<List<Machine>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Machine>>(200, "查询成功", this.machineService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param machine 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Machine> add(@RequestBody Machine machine) {
        return new JsonResult<>(200, "新增成功", this.machineService.insert(machine));
    }

    /**
     * 编辑数据
     *
     * @param machine 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Machine> edit(@RequestBody Machine machine) {
        return new JsonResult<>(200, "修改成功", this.machineService.update(machine));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.machineService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    @GetMapping("")
    public JsonResult queryByLimit(Machine machine, @Param("page")Integer page,@Param("num")Integer num){
        if (page==null||num==null) throw new CustomException(4006,"page或num为空");
        if (num<=0||page<=0) throw new CustomException(4007,"page<=0或num<=0");
        List list = machineService.queryByLike(machine, page-1, num);
        Integer integer = machineService.queryByLikeCount(machine);
        Map map=new HashMap();
        map.put("total",integer);
        map.put("machines",list);
        return new JsonResult(200,"查询成功",map);
    }
}
