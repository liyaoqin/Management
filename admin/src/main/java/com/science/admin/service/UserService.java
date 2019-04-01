package com.science.admin.service;

import com.science.admin.pojo.Adminuser;
import com.science.common.util.ScienceResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface UserService {
   public String getPassword(String name);
   public Adminuser getByName(String name);

   public List<Adminuser> list();
   public void add(Adminuser user);
   public void delete(Long id);
   public Adminuser get(Long id);
   public void update(Adminuser user);
   ScienceResult checkData(String content,Integer type);
   public ScienceResult createUser(Adminuser adminuser);
}
