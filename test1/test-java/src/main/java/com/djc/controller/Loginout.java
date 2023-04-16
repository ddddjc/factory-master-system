package com.djc.controller;

import com.djc.entity.Employee;
import com.djc.entity.Vo.QueryEmployeeVo;
import com.djc.exception.CustomException;
import com.djc.service.EmployeeService;
import com.djc.util.JsonResult;
import com.djc.util.JwtUtil;
import com.djc.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * {@code @Author:} djc
 * &#064;Date:  2023-04-15-19:40
 * @Description: 登录登出
 */
@RestController
@RequestMapping("/user")
public class Loginout {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    SessionUtil sessionUtil;
    @PostMapping("/login")
    public JsonResult login(@RequestBody Employee employee){
        QueryEmployeeVo employee1 = employeeService.queryById(employee.getEmployeeId());
        if (null==employee1){
            throw new CustomException(4004,"没有此用户");
        }else if (null==employee.getPassword()||!employee.getPassword().equals(employee1.getPassword())){
            return new JsonResult<>(441,"密码错误",null);
        }else{
            sessionUtil.setAttribute(employee.getEmployeeId().toString(),true);
            System.out.println(sessionUtil.getAttribute(employee.getEmployeeId().toString()).toString());
            return new JsonResult<>(200,"登陆成功", jwtUtil.generateToken(employee1));
        }
    }
    @GetMapping("/logout/{employeeId}")
    public JsonResult logout(@PathVariable Integer employeeId){
        System.out.println(employeeId);
        System.out.println(sessionUtil.getAttribute(employeeId.toString()).toString());
        sessionUtil.removeAttribute(employeeId.toString());
        return new JsonResult(200,"登出成功",null);
    }
    @PutMapping("/passwordUpdate")
    public JsonResult passwordUpdate(@RequestBody Employee employee,HttpServletRequest request){
        String token = request.getHeader("token");
        Employee employee1=jwtUtil.parseTokenToEmployee(token);
        System.out.println("employee1 = " + employee1);
        System.out.println("employee = " + employee);
        if (null==employee1){
            return new JsonResult(440,"没有该用户",null);
        }if(!employee1.getEmployeeId().equals(employee.getEmployeeId())||employee1.getRole().equals("manager")){
            return new JsonResult(559,"该用户权限不够",null);
        }
        else{
            employeeService.update(employee);
            return new JsonResult<>(200,"修改成功",null);
        }
    }
}
