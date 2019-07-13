package com.iedu.project.service;

import com.iedu.project.controller.model.SysUserExample;
import com.iedu.project.controller.model.User;
import com.iedu.project.entity.SysUser;

import java.util.List;


public interface UserService{
    public SysUser addUser(SysUser user);

    public List<User> searchUser(String uid, String nickname);

    SysUser findById(String id);

    SysUser editUser(SysUser user);
    public List<SysUser> searchByExample(SysUserExample example, int page, int limit);
    public int searchByExampleCount(SysUserExample example);
    String login(String loginname,String password);


}


























