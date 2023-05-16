package com.djc.controller;

import com.djc.entity.AccessoriesArrival;
import com.djc.entity.AccessoriesArrivalDetail;
import com.djc.entity.Employee;
import com.djc.entity.Information;
import com.djc.entity.Vo.AccessoriesArrivalVo;
import com.djc.service.AccessoriesArrivalDetailService;
import com.djc.service.AccessoriesArrivalService;
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
 * 到货单(AccessoriesArrival)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("arrival")
public class AccessoriesArrivalController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private AccessoriesArrivalService accessoriesArrivalService;

    @Autowired
    private AccessoriesArrivalDetailService accessoriesArrivalDetailService;

    @Autowired
    private InformationUtils informationUtils;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtUtil jwtUtil;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<AccessoriesArrivalVo> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.accessoriesArrivalService.queryVoById(id));
    }

    @GetMapping()
    public JsonResult queryByLike(AccessoriesArrival accessoriesArrival, @Param("page")Integer page,@Param("num") Integer num){
        List<AccessoriesArrival> list=accessoriesArrivalService.queryByLike(accessoriesArrival,page-1,num);
        Integer total=accessoriesArrivalService.likeNum(accessoriesArrival);
        Map map=new HashMap();
        map.put("accessoriesArrivalList",list);
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
    public JsonResult<List<AccessoriesArrival>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<AccessoriesArrival>>(200, "查询成功", this.accessoriesArrivalService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param accessoriesArrival 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<AccessoriesArrival> add(@RequestBody AccessoriesArrival accessoriesArrival) {
        return new JsonResult<>(200, "新增成功", this.accessoriesArrivalService.insert(accessoriesArrival));
    }

    /**
     * 编辑数据
     *
     * @param accessoriesArrival 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<AccessoriesArrival> edit(@RequestBody AccessoriesArrival accessoriesArrival) {
        return new JsonResult<>(200, "修改成功", this.accessoriesArrivalService.update(accessoriesArrival));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.accessoriesArrivalService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 给到货单新增详情
     * @param accessoriesArrivalDetail
     * @return
     */
    @PostMapping("/addAccessories")
    public JsonResult addAccessories(@RequestBody AccessoriesArrivalDetail accessoriesArrivalDetail){
        accessoriesArrivalDetailService.insert(accessoriesArrivalDetail);
        return new JsonResult(200,"新增成功");
    }

    /**
     * 给到货单删除详情
     * @param id
     * @return
     */
    @DeleteMapping("/delAccessories/{id}")
    public JsonResult delAccessories(@PathVariable("id")Integer id){
        accessoriesArrivalDetailService.deleteById(id);
        return new JsonResult(200,"删除成功");
    }

    /**
     * 提交到货单
     * @param id
     * @return
     */
    @PutMapping("submit/{id}")
    public JsonResult submitArrival(@PathVariable("id")Integer id, HttpServletRequest request) throws ParseException {
        String token = request.getHeader("token");
        AccessoriesArrival accessoriesArrival = accessoriesArrivalService.queryById(id);
        accessoriesArrival.setArrivalState("Submitted");
        accessoriesArrivalService.update(accessoriesArrival);
        List<Employee> employees = employeeService.queryByRole("admin");
        List<Employee> employees1 = employeeService.queryByRole("manager");
        employees.addAll(employees1);
        Employee employee = jwtUtil.parseTokenToEmployee(token);
        informationUtils.sendInformation(employee.getEmployeeId(),employees,"有人提交了到货单","","一般");
        return new JsonResult(200,"提交成功");
    }
    /**
     * 审核
     * @param accessoriesArrival
     * @return
     */
    @PutMapping("state")
    public JsonResult setState(@RequestBody AccessoriesArrival accessoriesArrival){
        accessoriesArrivalService.update(accessoriesArrival);
        return new JsonResult(200,"查询成功");
    }
}