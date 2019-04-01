package com.science.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/boot/hello")
    public String hello(){
        //r如果是对象返回json串，如果是字符串返回字符串
        return "register";
    }
}
