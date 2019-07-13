package com.iedu.project.controller;


import com.iedu.project.controller.model.Message;
import com.iedu.project.controller.model.SysUserExample;
import com.iedu.project.controller.model.User;
import com.iedu.project.commons.TableData;
import com.iedu.project.entity.SysUser;
import com.iedu.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/logic/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("{id}")
    @ResponseBody
    public SysUser userDetail(@PathVariable("id") String id){
        SysUser user=service.findById(id);

        return user;
    }
    @RequestMapping("login")
    @ResponseBody
    public String  login(String loginname, String password, HttpSession session) {
        System.out.println(loginname);
        String user = service.login(loginname, password);
        if (user != null) {
            session.setAttribute("user_session", user);
            return user;
        } else {
            return null;
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Message addUser(SysUser user){

        SysUser result=service.addUser(user);
        Message msg=new Message();
        if (result.getId()!=null){
            msg.setMsg("成功创建用户");
            msg.setState(0);
        }else {
            msg.setMsg("用户创建失败");
            msg.setState(-1);
        }
        msg.setData(result);
        return msg;

    }
    @RequestMapping("search")
    @ResponseBody
    public TableData<SysUser> searchMovieTop250ByExample(int page, int limit, SysUserExample example){

        TableData<SysUser> result=new TableData();

        List<SysUser> sysUserList=service.searchByExample(example,page, limit);
        int allcount=service.searchByExampleCount(example);
        result.setCount(allcount);
        result.setData(sysUserList);
        result.setCode(0);
        result.setMsg("成功加载");

        return result;
    }

    @RequestMapping("delete")
    public String deUser(){
        return "addUser";
    }
    @RequestMapping("edit")
    @ResponseBody
    public Message editUser(SysUser user){
        Message msg=new Message();
        user=service.editUser(user);
        if (user!=null){
            msg.setData(user);
            msg.setState(0);
            msg.setMsg("信息更新成功");
        }else {
            msg.setState(-1);
            msg.setMsg("用户信息更新失败");
        }

        return msg;
    }

}
