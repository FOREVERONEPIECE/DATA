package com.iedu.project.service.impl;

import com.iedu.project.commons.MD5Tools;
import com.iedu.project.controller.model.SysUserExample;
import com.iedu.project.controller.model.User;
import com.iedu.project.entity.SysUser;
import com.iedu.project.mapper.SysUserMapper;
import com.iedu.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper mapper;
    public SysUser addUser(SysUser user){
        SysUser tmp=mapper.selectByUid(user.getUid());
        if (tmp==null){
            String pwd= MD5Tools.buildMD5StringNoraml(user.getPwd());
            user.setPwd(pwd);
            mapper.insert(user);
        }
        return user;
    }

    public List<User> searchUser(String uid,String nickName) {
        List<User> result = new ArrayList();
        for (int i =0;i<10;i++){
            User user = new User();
            user.setUid("User"+i);
            user.setNickName("NickName"+i);
            user.setState(1);
            user.setType(0);
            result.add(user);
        }
        return result;
    }
    public String login(String loginname, String password) {
        String pwd = MD5Tools.buildMD5StringNoraml(password);
        if(mapper.selectByLoginnameAndPassword(loginname, pwd)==null){
            return "用户名或密码错误，请重新输入";
        }
        else {
            return "登录成功";
        }
    }


    public SysUser findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    public SysUser editUser(SysUser user) {
        if (mapper.updateByPrimaryKeySelective(user)==1)
        {
            user=mapper.selectByPrimaryKey(user.getId());
            return user;
        }
        else {
            return null;
        }
    }
    public List<SysUser> searchByExample(SysUserExample example, int page, int limit){

        int begin =limit*(page-1);
        List<SysUser> result=mapper.selectByExample(example,begin,limit);

        return result;
    }
    public int searchByExampleCount(SysUserExample example){
        return mapper.selectExampleCount(example);
    }

}
