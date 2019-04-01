package com.science.admin.service.Impl;

import com.science.admin.mapper.AdminuserMapper;
import com.science.admin.pojo.Adminuser;
import com.science.admin.pojo.AdminuserExample;
import com.science.admin.service.UserRoleService;
import com.science.admin.service.UserService;
import com.science.common.util.ScienceResult;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    AdminuserMapper adminuserMapper;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public String getPassword(String name) {
        Adminuser user = getByName(name);
        if(null==user){
            return null;
        }
        return user.getPassword();
    }

    @Override
    public Adminuser getByName(String name) {
        AdminuserExample example = new AdminuserExample();
        example.createCriteria().andUsernameEqualTo(name);
        List<Adminuser> users = adminuserMapper.selectByExample(example);
        if(users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public void add(Adminuser u) {
        adminuserMapper.insert(u);
    }

    @Override
    public void delete(Long id) {
        adminuserMapper.deleteByPrimaryKey(id);
        userRoleService.deleteByUser(id);
    }

    @Override
    public void update(Adminuser u) {
        adminuserMapper.updateByPrimaryKeySelective(u);
    }

    @Override
    public ScienceResult checkData(String content, Integer type) {
        AdminuserExample example=new AdminuserExample();
        AdminuserExample.Criteria criteria = example.createCriteria();
        if(1==type){
            criteria.andUsernameEqualTo(content);
        }else if(2==type){
            criteria.andPhoneEqualTo(content);
        }else{
            criteria.andEmailEqualTo(content);
        }
        List<Adminuser> list = adminuserMapper.selectByExample(example);
        if(list==null || list.size()==0){
            return ScienceResult.ok(true);
        }
        return ScienceResult.ok(false);
    }

    @Override
    public Adminuser get(Long id) {
        return adminuserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Adminuser> list(){
        AdminuserExample example =new AdminuserExample();
        example.setOrderByClause("id desc");
        return adminuserMapper.selectByExample(example);

    }
    @Override
    public ScienceResult createUser(Adminuser adminuser){
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";

        String encodedPassword = new SimpleHash(algorithmName,adminuser.getPassword(),salt,times).toString();

        Adminuser u = new Adminuser();
        u.setUsername(adminuser.getUsername());
        u.setPassword(encodedPassword);
        u.setPhone(adminuser.getPhone());
        u.setEmail(adminuser.getEmail());
        u.setSalt(salt);
        u.setCreated(new Date());
        u.setUpdated(new Date());
        add(u);
        return ScienceResult.ok();
    }
}
