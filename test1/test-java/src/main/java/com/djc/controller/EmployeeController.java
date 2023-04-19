package com.djc.controller;

import com.djc.entity.Employee;
import com.djc.entity.Vo.QueryEmployeeVo;
import com.djc.exception.CustomException;
import com.djc.service.EmployeeService;
import com.djc.util.JsonResult;
import com.djc.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工表(Employee)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("user")
public class EmployeeController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtUtil jwtUtil;

//    /**
//     * 分页查询
//     *
//     * @param employee    筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    @GetMapping("/useless")
//    public JsonResult<Page<Employee>> queryByPage(Employee employee, PageRequest pageRequest) {
//        return new JsonResult<>(200, "查询成功", this.employeeService.queryByPage(employee, pageRequest));
//    }

    /**
     * 条件查询
     * @param employee
     * @param num
     * @param page
     * @return
     */
    @GetMapping()
    public JsonResult queryByCondition(Employee employee, @Param("num") Integer num,@Param("page") Integer page){
        if (num==null||page==null) throw new CustomException(4002,"请输入页码和数量");
        if (num<=0||page<=0) throw new CustomException(4006,"页码和数量不能小于0");
        List<QueryEmployeeVo> employees = this.employeeService.queryByLike(employee, num, page - 1);
        Integer integer = employees.size();
        Map map=new HashMap();
        map.put("employees",employees);
        map.put("num",integer);
        return new JsonResult<>(200,"查询成功",map);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<QueryEmployeeVo> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.employeeService.queryById(id));
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
    public JsonResult<List<Employee>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Employee>>(200, "查询成功", this.employeeService.queryAll(keyword, page-1, num));
    }

    /**
     * 新增数据
     *
     * @param employee 实体
     * @return 新增结果
     */

    @PostMapping()
    public JsonResult<Employee> add(@RequestBody Employee employee) {
        employee.setEmployeeId(null);
        employee.setPassword("12345678");
        return new JsonResult<>(200, "新增成功", this.employeeService.insert(employee));
    }

    /**
     * 编辑数据
     *
     * @param employee 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult edit(@RequestBody Employee employee) {
        return new JsonResult<>(200, "修改成功", this.employeeService.update(employee));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.employeeService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 设置小组
     * @param employee
     * @return
     */
    @PutMapping("setgroup")
    public JsonResult setgroup(@RequestBody Employee employee){
        Employee employee1=new Employee();
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setTeamId(employee.getTeamId());
        employeeService.update(employee1);
        return new JsonResult(200,"设置修改",null);
    }
    @PostMapping("/aa")
    public String hello(){
        return "hello";
    }

    @PostMapping("/addSome")
    public JsonResult addSome(@RequestBody Map<String, Object> map) {
        List<Employee> employeeList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Object obj : (List<Object>) map.get("list")) {
            Employee employee = objectMapper.convertValue(obj, Employee.class);
            employeeList.add(employee);
        }
        for (Employee employee : employeeList) {
            employeeService.insert(employee);
        }
        return new JsonResult(200, "添加成功", null);
    }

    /**
     * 查询权限
     * @param role
     * @return
     */
    @GetMapping("/permission/{role}")
    public JsonResult getPermission(@PathVariable("role") String role){
        return new JsonResult(200,"查询成功",employeeService.queryPermission(role));
    }
    @GetMapping("/findUser")
    public JsonResult findUser(HttpServletRequest request){
        String token = request.getHeader("token");
        if (token==null||token=="") throw new CustomException(5001,"token为空");
        Employee employee = jwtUtil.parseTokenToEmployee(token);
        return queryById(employee.getEmployeeId());
    }
}
