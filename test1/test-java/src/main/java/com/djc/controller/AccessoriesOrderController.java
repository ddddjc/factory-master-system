package com.djc.controller;

import com.djc.entity.AccessoriesOrder;
import com.djc.service.AccessoriesOrderService;
import com.djc.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 到货单(AccessoriesOrder)表控制层
 *
 * @author djc
 * @since 2023-05-18 15:17:23
 */
@RestController
@RequestMapping("accessoriesOrder")
public class AccessoriesOrderController {
    /**
     * 服务对象
     */
    @Resource
    private AccessoriesOrderService accessoriesOrderService;

    /**
     * 分页查询
     *
     * @param accessoriesOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public JsonResult<Page<AccessoriesOrder>> queryByPage(AccessoriesOrder accessoriesOrder, PageRequest pageRequest) {
        return new JsonResult<>(200,"查询成功",this.accessoriesOrderService.queryByPage(accessoriesOrder, pageRequest));
    }

    /**
     * 模糊条件查询
     * @param accessoriesOrder
     * @param num
     * @param page
     * @return
     */
    @GetMapping()
    public JsonResult queryByLike(AccessoriesOrder accessoriesOrder, @Param("num")Integer num, @Param("page")Integer page){
        List<AccessoriesOrder> orders=accessoriesOrderService.queryByLike(accessoriesOrder,page-1,num);
        Integer total=accessoriesOrderService.queryNumByLike(accessoriesOrder);
        Map accessoriesOrderList = new HashMap();
        accessoriesOrderList.put("orders",orders);
        accessoriesOrderList.put("total",total);
        return new JsonResult(200,"查询成功",accessoriesOrderList);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesOrder> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200,"查询成功",this.accessoriesOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param accessoriesOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public JsonResult<AccessoriesOrder> add(@RequestBody AccessoriesOrder accessoriesOrder) {
        System.out.println(accessoriesOrder);
        return new JsonResult<>(200,"新增成功",this.accessoriesOrderService.insert(accessoriesOrder));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesOrder> edit(@RequestBody AccessoriesOrder accessoriesOrder) {
        return new JsonResult<>(200,"修改成功",this.accessoriesOrderService.update(accessoriesOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/id")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200,"删除成功",this.accessoriesOrderService.deleteById(id));
    }

}

