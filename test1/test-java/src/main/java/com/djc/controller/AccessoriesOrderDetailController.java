package com.djc.controller;

import com.djc.entity.AccessoriesOrder;
import com.djc.entity.AccessoriesOrderDetail;
import com.djc.service.AccessoriesOrderDetailService;
import com.djc.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 到货详情(AccessoriesOrderDetail)表控制层
 *
 * @author djc
 * @since 2023-05-18 15:17:25
 */
@RestController
@RequestMapping("accessoriesOrderDetail")
public class AccessoriesOrderDetailController {
    /**
     * 服务对象
     */
    @Resource
    private AccessoriesOrderDetailService accessoriesOrderDetailService;

    /**
     * 分页查询
     *
     * @param accessoriesOrderDetail 筛选条件
     * @param pageRequest            分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public JsonResult<Page<AccessoriesOrderDetail>> queryByPage(AccessoriesOrderDetail accessoriesOrderDetail, PageRequest pageRequest) {
        return new JsonResult<>(200,"查询成功",this.accessoriesOrderDetailService.queryByPage(accessoriesOrderDetail, pageRequest));
    }
    @GetMapping()
    public JsonResult queryByLike(AccessoriesOrderDetail accessoriesOrderDetail, @Param("page")Integer page,@Param("size")Integer size){
        List<AccessoriesOrderDetail> orderDetails=accessoriesOrderDetailService.queryByLike(accessoriesOrderDetail,page-1,size);
        Integer total=accessoriesOrderDetailService.queryNumByLike(accessoriesOrderDetail);
        Map orderDetailList = new HashMap();
        orderDetailList.put("orderDetails",orderDetails);
        orderDetailList.put("total",total);
        return new JsonResult(200,"查询成功",orderDetailList);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesOrderDetail> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200,"查询成功",this.accessoriesOrderDetailService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param accessoriesOrderDetail 实体
     * @return 新增结果
     */
    @PostMapping
    public JsonResult<AccessoriesOrderDetail> add(@RequestBody AccessoriesOrderDetail accessoriesOrderDetail) {
        return new JsonResult<>(200,"新增成功",this.accessoriesOrderDetailService.insert(accessoriesOrderDetail));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesOrderDetail 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesOrderDetail> edit(AccessoriesOrderDetail accessoriesOrderDetail) {
        return new JsonResult<>(200,"修改成功",this.accessoriesOrderDetailService.update(accessoriesOrderDetail));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200,"删除成功",this.accessoriesOrderDetailService.deleteById(id));
    }
}

