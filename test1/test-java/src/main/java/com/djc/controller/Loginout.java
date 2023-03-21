package com.djc.controller;

import com.djc.entity.Employee;
import com.djc.service.EmployeeService;
import com.djc.util.JsonResult;
import com.djc.util.JwtUtil;
import com.djc.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Employee employee1 = employeeService.queryById(employee.getEmployeeId());
        if (null==employee1){
            return new JsonResult<>(441,"没有此用户",null);
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
    public JsonResult passwordUpdate(@RequestBody Employee employee){
        Employee employee1 = employeeService.queryById(employee.getEmployeeId());
        if (null==employee1){
            return new JsonResult(440,"没有该用户",null);
        }
        else{
            employeeService.update(employee);
            return new JsonResult<>(200,"修改成功",null);
        }
    }
}
