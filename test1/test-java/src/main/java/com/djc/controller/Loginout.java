package com.djc.controller;

import com.djc.entity.Employee;
import com.djc.exception.CustomException;
import com.djc.service.EmployeeService;
import com.djc.service.impl.WebSocket;
import com.djc.util.JsonResult;
import com.djc.util.JwtUtil;
import com.djc.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CopyOnWriteArraySet;

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
    @Autowired
    private WebSocket webSocket;
    @PostMapping("/login")
    public JsonResult login(@RequestBody Employee employee){
        if (employee.getEmployeeId()==null)
            throw new CustomException(4001,"请输入id");
        if (employee.getPassword()==null)
            throw new CustomException(4002,"请输入密码");
        Employee employee1 = employeeService.queryPassword(employee.getEmployeeId());
        if (null==employee1){
            throw new CustomException(4004,"没有此用户");
        }else if (null==employee.getPassword()||!employee.getPassword().equals(employee1.getPassword())){
            return new JsonResult<>(4044,"密码错误",null);
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
        CopyOnWriteArraySet<WebSocket> webSockets = WebSocket.getWebSockets();
        for (WebSocket w:webSockets){
            if (w!=null||w.getEmployeeId()==null||w.getEmployeeId()==employeeId){
                webSockets.remove(w);
            }
        }
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
            return new JsonResult(4400,"没有该用户",null);
        }if(!employee1.getEmployeeId().equals(employee.getEmployeeId())||employee1.getRole().equals("manager")){
            return new JsonResult(5009,"该用户权限不够",null);
        }
        else{
            employeeService.update(employee);
            return new JsonResult<>(200,"修改成功",null);
        }
    }
}
