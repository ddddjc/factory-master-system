package com.djc.controller;

import com.djc.entity.RepairRequest;
import com.djc.service.RepairRequestService;
import com.djc.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 维修请求(RepairRequest)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("repairRequest")
public class RepairRequestController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private RepairRequestService repairRequestService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<RepairRequest> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.repairRequestService.queryById(id));
    }

    @GetMapping()
    public JsonResult queryByLike(RepairRequest repairRequest,@Param("num")Integer num, @Param("page")Integer page){
        List<RepairRequest> requestList=repairRequestService.queryByLike(repairRequest,num,page-1);
        Integer total=repairRequestService.queryLikeCount(repairRequest);
        Map map=new HashMap();
        map.put("total",total);
        map.put("requestList",requestList);
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
    public JsonResult<List<RepairRequest>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<RepairRequest>>(200, "查询成功", this.repairRequestService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param repairRequest 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<RepairRequest> add(@RequestBody RepairRequest repairRequest) {
        return new JsonResult<>(200, "新增成功", this.repairRequestService.insert(repairRequest));
    }

    /**
     * 编辑数据
     *
     * @param repairRequest 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<RepairRequest> edit(@RequestBody RepairRequest repairRequest) {
        return new JsonResult<>(200, "修改成功", this.repairRequestService.update(repairRequest));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.repairRequestService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 修改状态（需要权限）
     * @param repairRequest
     * @return
     */
    @PutMapping("/progress")
    public JsonResult setProgress(@RequestBody RepairRequest repairRequest){
        return edit(repairRequest);
    }
}
