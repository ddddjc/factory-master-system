package com.djc.controller;

import com.djc.entity.Accessories;
import com.djc.entity.Machine;
import com.djc.entity.MachineType;
import com.djc.entity.Vo.AccessoriesOfMachineTypeVo;
import com.djc.exception.CustomException;
import com.djc.service.AccessoriesService;
import com.djc.service.MachineService;
import com.djc.service.MachineTypeService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 机器类型(按种类）
 * (MachineType)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("machineType")
public class MachineTypeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private MachineTypeService machineTypeService;

    @Autowired
    private AccessoriesService accessoriesService;
    @Autowired
    private MachineService machineService;
    @GetMapping()
    public JsonResult queryByLimit(MachineType machineType, @Param("page")Integer page,@Param("num")Integer num){
        if (page==null||num==null)
            throw new CustomException(4004,"请输入页码和容量");
          List<MachineType> list= this.machineTypeService.queryByLike(machineType,page-1,num);
        Integer integer = machineTypeService.queryBylikeCount(machineType);
        Map map=new HashMap();
        map.put("total",integer);
        map.put("machineTypes",list);
        return new JsonResult(200,"查询成功",map);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.machineTypeService.queryById(id));
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
    public JsonResult<List<MachineType>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<MachineType>>(200, "查询成功", this.machineTypeService.queryAll(keyword, page-1, num));
    }

    /**
     * 新增数据
     *
     * @param machineType 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<MachineType> add(@RequestBody MachineType machineType) {
        return new JsonResult<>(200, "新增成功", this.machineTypeService.insert(machineType));
    }

    /**
     * 编辑数据
     *
     * @param machineType 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult edit(@RequestBody MachineType machineType) {
        return new JsonResult<>(200, "修改成功", this.machineTypeService.update(machineType));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.machineTypeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(5000, "删除失败", false);
        }
    }

    /**
     * 查询机器对应的零件
     * @param machineTypeId
     * @param num
     * @param page
     * @return
     */
    @GetMapping("/findAccessories/{machineTypeId}")
    public JsonResult findAccessories(@PathVariable("machineTypeId") Integer machineTypeId,@Param("num")Integer num,@Param("page")Integer page){
        AccessoriesOfMachineTypeVo accessories = machineTypeService.findAccessories(machineTypeId, num, page - 1);
        Accessories accessories1=new Accessories();
        accessories1.setMachineTypeId(machineTypeId);
        Integer total=accessoriesService.queryByLikeCount(accessories1);
        Map map=new HashMap();
        map.put("total",total);
        map.put("accessories",accessories);
        return new JsonResult(200,"查询成功",map);
    }

    @GetMapping("/qurrymachine/{machineTypeId}")
    public JsonResult findMachines(Machine machine,@Param("page") Integer page,@Param("num")Integer num){
        List list = machineService.queryByLimit(machine, page - 1, num);
        Integer total=list.size();
        Map map=new HashMap();
        map.put("total",total);
        map.put("machineList",list);
        return new JsonResult(200,"查询成功",map);
    }
}
