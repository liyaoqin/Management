package com.science.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class PageController {
    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    @GetMapping("/index")
    public String showindex() {
        return "index";
    }
    @GetMapping("/page/cnotice")
    public String showcnotice(@ModelAttribute("pid") String pid,Model model) {
        model.addAttribute("pid",pid);
        return "page/cnotice";
    }
    @GetMapping("/unauthorized")
    public String noPerms() {
        return "unauthorized";
    }

}
