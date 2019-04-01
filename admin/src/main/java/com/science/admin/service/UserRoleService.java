package com.science.admin.service;

import com.science.admin.pojo.Adminuser;

public interface UserRoleService {
    public void setRoles(Adminuser user, long[] roleIds);
    public void deleteByUser(long userId);
    public void deleteByRole(long roleId);
}
