package com.science.admin.controller;

import com.science.admin.pojo.Adminuser;
import com.science.admin.pojo.Role;
import com.science.admin.service.RoleService;
import com.science.admin.service.UserRoleService;
import com.science.admin.service.UserService;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("config")
public class UserController {
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping("listUser")
    public String list(Model model){
        List<Adminuser> us= userService.list();
        model.addAttribute("us", us);
        Map<Adminuser,List<Role>> user_roles = new HashMap<>();
        for (Adminuser user : us) {
            List<Role> roles=roleService.listRoles(user);
            user_roles.put(user, roles);
        }
        model.addAttribute("user_roles", user_roles);

        return "listUser";
    }
    @RequestMapping("editUser")
    public String edit(Model model,long id){
        List<Role> rs = roleService.list();
        model.addAttribute("rs", rs);
        Adminuser user =userService.get(id);
        model.addAttribute("user", user);

        List<Role> roles =roleService.listRoles(user);
        model.addAttribute("currentRoles", roles);

        return "editUser";
    }
    @RequestMapping("deleteUser")
    public String delete(Model model,long id){
        userService.delete(id);
        return "redirect:listUser";
    }
    @Transactional
    @RequestMapping("updateUser")
    public String update(Adminuser user,long[] roleIds){
        userRoleService.setRoles(user,roleIds);

        String password=user.getPassword();
        //如果在修改的时候没有设置密码，就表示不改动密码
        if(user.getPassword().length()!=0) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 2;
            String algorithmName = "md5";
            String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
            user.setSalt(salt);
            user.setPassword(encodedPassword);
        }
        else{
            user.setPassword(null);
        }
        userService.update(user);

        return "redirect:listUser";

    }

    @RequestMapping("addUser")
    public String add(Model model, String username, String password){

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";

        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();

        Adminuser u = new Adminuser();
        u.setUsername(username);
        u.setPassword(encodedPassword);
        u.setSalt(salt);
        u.setCreated(new Date());
        u.setUpdated(new Date());
        userService.add(u);

        return "redirect:listUser";
    }


}
