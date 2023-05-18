package com.djc.controller;

import com.djc.entity.AccessoriesOutbound;
import com.djc.entity.AccessoriesOutboundDetail;
import com.djc.entity.Employee;
import com.djc.entity.Vo.AccessoriesOutboundVo;
import com.djc.service.AccessoriesOutboundDetailService;
import com.djc.service.AccessoriesOutboundService;
import com.djc.service.EmployeeService;
import com.djc.util.InformationUtils;
import com.djc.util.JsonResult;
import com.djc.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出库申请（领材料申请单）(AccessoriesOutbound)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("outbound")
public class AccessoriesOutboundController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesOutboundService accessoriesOutboundService;

    @Autowired
    private AccessoriesOutboundDetailService accessoriesOutboundDetailService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InformationUtils informationUtils;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesOutboundVo> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesOutboundService.queryVoById(id));
    }

    @GetMapping()
    public JsonResult queryByLike(AccessoriesOutbound accessoriesOutbound, @Param("page")Integer page, @Param("num")Integer num){
        List<AccessoriesOutbound> outboundList=accessoriesOutboundService.queryByLike(accessoriesOutbound,page-1,num);
        Integer total=accessoriesOutboundService.likeNum(accessoriesOutbound);
        Map map=new HashMap<>();
        map.put("total",total);
        map.put("outboundList",outboundList);
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
    public JsonResult<List<AccessoriesOutbound>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<AccessoriesOutbound>>(200, "查询成功", this.accessoriesOutboundService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesOutbound 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesOutbound> add(@RequestBody AccessoriesOutbound accessoriesOutbound,HttpServletRequest request) {
        Employee employee = jwtUtil.parseTokenToEmployee(request.getHeader("token"));
        System.out.println(employee.getEmployeeId());
        accessoriesOutbound.setEmployeeId(employee.getEmployeeId());
        return new JsonResult<>(200, "新增成功", this.accessoriesOutboundService.insert(accessoriesOutbound));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesOutbound 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesOutbound> edit(@RequestBody AccessoriesOutbound accessoriesOutbound,HttpServletRequest request) {
        Employee employee = jwtUtil.parseTokenToEmployee(request.getHeader("token"));
        System.out.println(employee.getEmployeeId());
        accessoriesOutbound.setEmployeeId(employee.getEmployeeId());
        return new JsonResult<>(200, "修改成功", this.accessoriesOutboundService.update(accessoriesOutbound));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesOutboundService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 给入库单新增详情
     * @param accessoriesOutboundDetail
     * @return
     */
    @PostMapping("addAccessories")
    public JsonResult addAccessories(@RequestBody AccessoriesOutboundDetail accessoriesOutboundDetail){
        accessoriesOutboundDetailService.insert(accessoriesOutboundDetail);
        return new JsonResult(200,"新增成功");
    }
    @DeleteMapping("delAccessories/{outboundDetailId}")
    public JsonResult delAccessories(@PathVariable("outboundDetailId")Integer id){
        accessoriesOutboundDetailService.deleteById(id);
        return new JsonResult(200,"删除成功");
    }
    @PutMapping("submit/{id}")
    public JsonResult submitOutbound(@PathVariable("id")Integer id, HttpServletRequest request) throws ParseException {
        AccessoriesOutbound accessoriesOutbound = accessoriesOutboundService.queryById(id);
        accessoriesOutbound.setOutboundState("Submitted");
        String token = request.getHeader("token");
        Employee employee = jwtUtil.parseTokenToEmployee(token);
        List<Employee> employees = employeeService.queryByRole("manager");
        informationUtils.sendInformation(employee.getEmployeeId(),employees,"有人提交了出库单","","一般");
        return new JsonResult(200,"提交成功");
    }
    /**
     * 设置审核状态
     * @param accessoriesOutbound
     * @return
     */
    @PutMapping("state")
    public JsonResult setState(@RequestBody AccessoriesOutbound accessoriesOutbound){
        accessoriesOutboundService.update(accessoriesOutbound);
        return new JsonResult<>(200,"设置成功");
    }
}
