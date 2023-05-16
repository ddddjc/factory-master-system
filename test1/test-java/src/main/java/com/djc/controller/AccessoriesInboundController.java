package com.djc.controller;

import com.djc.entity.AccessoriesInbound;
import com.djc.entity.AccessoriesInboundDetail;
import com.djc.entity.Employee;
import com.djc.entity.Vo.AccessoriesInboundVo;
import com.djc.service.AccessoriesInboundDetailService;
import com.djc.service.AccessoriesInboundService;
import com.djc.service.EmployeeService;
import com.djc.util.InformationUtils;
import com.djc.util.JsonResult;
import com.djc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 入库信息(AccessoriesInbound)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("inbound")
public class AccessoriesInboundController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesInboundService accessoriesInboundService;
    @Autowired
    private AccessoriesInboundDetailService accessoriesInboundDetailService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    InformationUtils informationUtils;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesInboundVo> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesInboundService.queryVoById(id));
    }

    @GetMapping("")
    public JsonResult queryByLike(AccessoriesInbound accessoriesInbound,@Param("page")Integer page, @Param("num")Integer num){
        List<AccessoriesInbound> liest=accessoriesInboundService.queryByLike(accessoriesInbound,page-1,num);
        Integer total=accessoriesInboundService.LikeNum(accessoriesInbound);
        Map map=new HashMap();
        map.put("inboundList",liest);
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
    public JsonResult<List<AccessoriesInbound>> findAll(String keyword, int page, int num) {

        return new JsonResult<List<AccessoriesInbound>>(200, "查询成功", this.accessoriesInboundService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesInbound 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesInbound> add(@RequestBody AccessoriesInbound accessoriesInbound) {
        return new JsonResult<>(200, "新增成功", this.accessoriesInboundService.insert(accessoriesInbound));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesInbound 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesInbound> edit(@RequestBody AccessoriesInbound accessoriesInbound) {
        return new JsonResult<>(200, "修改成功", this.accessoriesInboundService.update(accessoriesInbound));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesInboundService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 给入库单新增详情
     * @param accessoriesInboundDetail
     * @return
     */
    @PostMapping("addAccessories")
    public JsonResult addAccessories(@RequestBody AccessoriesInboundDetail accessoriesInboundDetail){
        accessoriesInboundDetailService.insert(accessoriesInboundDetail);
        return new JsonResult(200,"新增成功");
    }

    /**
     * 给入库单删除详情
     * @param id
     * @return
     */
    @DeleteMapping("delAccessories/{inboundDetialId}")
    public JsonResult delAccessories(@PathVariable("inboundDetialId") Integer id){
        accessoriesInboundDetailService.deleteById(id);
        return new JsonResult(200,"删除成功");
    }

    /**
     * 提交入库单
     * @param id
     * @return
     */
    @PutMapping("submit/{id}")
    public JsonResult submitInbound(@PathVariable("id")Integer id, HttpServletRequest request) throws ParseException {
        AccessoriesInbound accessoriesInbound = accessoriesInboundService.queryById(id);
        accessoriesInbound.setInboundState("Submitted");
        accessoriesInboundService.update(accessoriesInbound);
        String token = request.getHeader("token");
        Employee employee = jwtUtil.parseTokenToEmployee(token);
        List<Employee> employees = employeeService.queryByRole("manager");
        informationUtils.sendInformation(employee.getEmployeeId(),employees,"有人提交了入库单","","一般");
        return new JsonResult(200,"提交成功");
    }
    /**
     * 修改审核状态
     * @param accessoriesInbound
     * @return
     */
    @PutMapping("state")
    public JsonResult setState(@RequestBody AccessoriesInbound accessoriesInbound){
        accessoriesInboundService.update(accessoriesInbound);
        return new JsonResult(200,"修改成功");
    }
}
