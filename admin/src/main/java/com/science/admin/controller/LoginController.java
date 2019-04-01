package com.science.admin.controller;

import com.science.admin.pojo.Adminuser;
import com.science.admin.service.UserService;
import com.science.common.util.ExceptionUtil;
import com.science.common.util.ScienceResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            //获取已登录的用户信息
            Adminuser activeUser = (Adminuser) subject.getPrincipal();
            session.setAttribute("activeUser", activeUser);
            return "redirect:index";

        } catch (AuthenticationException e) {
            model.addAttribute("error", "验证失败");
            return "login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ScienceResult register(Adminuser adminuser){
        try {
            ScienceResult result = userService.createUser(adminuser);
            return result;
        } catch (Exception e) {
            return ScienceResult.build(500, ExceptionUtil.getStackTrace(e));
        }

    }

    @RequestMapping("/check/{param}/{type}")
    @ResponseBody
    public Object checkData(@PathVariable String param, @PathVariable Integer type) {
        ScienceResult result=null;
        if(StringUtils.isBlank(param)){
            result=ScienceResult.build(400,"校验内容不能为空");
        }
        if(type==null){
            result=ScienceResult.build(400,"校验内容类型不能为空");
        }
        else if(type!=1&&type!=2&&type!=3){
            result=ScienceResult.build(400,"校验内容类型错误");
        }
        if(null!=result){
            return result;
        }
        try {
            result = userService.checkData(param, type);

        } catch (Exception e) {
            result = ScienceResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }
}

