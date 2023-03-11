package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class helloword {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("test1");
        return "hello";
    }
}
