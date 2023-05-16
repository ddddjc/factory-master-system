package com.djc.controller;

import com.djc.entity.AccessoriesProcurement;
import com.djc.entity.AccessoriesProcurementDetail;
import com.djc.entity.Vo.AccessoriesProcurementVo;
import com.djc.exception.CustomException;
import com.djc.service.AccessoriesProcurementDetailService;
import com.djc.service.AccessoriesProcurementService;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采购信息(AccessoriesProcurement)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("procurement")
public class AccessoriesProcurementController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesProcurementService accessoriesProcurementService;

    @Autowired
    private AccessoriesProcurementDetailService accessoriesProcurementDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesProcurementVo> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesProcurementService.queryVoById(id));
    }
    @GetMapping()
    public JsonResult queryByLike(AccessoriesProcurement accessoriesProcurement, @Param("page")Integer page,@Param("num")Integer num){
        List<AccessoriesProcurement> list=accessoriesProcurementService.queryByLike(accessoriesProcurement,page-1,num);
        Integer total=accessoriesProcurementService.likeNum(accessoriesProcurement);
        Map map=new HashMap();
        map.put("total",total);
        map.put("procurementList",list);
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
    public JsonResult<List<AccessoriesProcurement>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<AccessoriesProcurement>>(200, "查询成功", this.accessoriesProcurementService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesProcurement 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesProcurement> add(@RequestBody AccessoriesProcurement accessoriesProcurement) {
        return new JsonResult<>(200, "新增成功", this.accessoriesProcurementService.insert(accessoriesProcurement));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesProcurement 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesProcurement> edit(@RequestBody AccessoriesProcurement accessoriesProcurement) {
        if (accessoriesProcurement.getProcurementId()==null) throw new CustomException(4005,"请输入正确的采购单id");
        return new JsonResult<>(200, "修改成功", this.accessoriesProcurementService.update(accessoriesProcurement));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesProcurementService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 新增详情
     * @param accessoriesProcurementDetail
     * @return
     */
    @PostMapping("addAccessories")
    public JsonResult addAccessories(@RequestBody AccessoriesProcurementDetail accessoriesProcurementDetail){
        AccessoriesProcurementDetail insert = accessoriesProcurementDetailService.insert(accessoriesProcurementDetail);
        return new JsonResult(200,"新增成功");
    }

    /**
     * 删除详情
     * @param procurementDetailId
     * @return
     */
    @DeleteMapping("delAccessories/{procurementDetailId}")
    public JsonResult delAccessories(@PathVariable("procurementDetailId") Integer procurementDetailId){
        boolean b = accessoriesProcurementDetailService.deleteById(procurementDetailId);
        if (b) return new JsonResult(200,"删除成功");
        else return new JsonResult(4003,"删除失败，该详情可能不存在");
    }

    /**
     * 提交申购单
     * 同时发送WebSocket消息
     * @param id
     * @return
     */
    @PutMapping("submit/{id}")
    public JsonResult submitProcuement(@PathVariable("id") Integer id){
        AccessoriesProcurement accessoriesProcurement = accessoriesProcurementService.queryById(id);
        accessoriesProcurement.setProcurementState("Submitted");
        accessoriesProcurementService.update(accessoriesProcurement);

        return new JsonResult(200,"提交成功");
    }


    /**
     * 审核申请
     * @param accessoriesProcurement
     * @return
     */
    @PutMapping("state")
    public JsonResult setState(@RequestBody AccessoriesProcurement accessoriesProcurement){
        accessoriesProcurementService.update(accessoriesProcurement);
        return new JsonResult(200,"修改成功");
    }

}
