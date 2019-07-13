package com.iedu.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("user/search")
    public String searchUserPage(){
        return "searchUser";
    }
    @RequestMapping("user/add")
    public String addUserPage(){
        return "addUser";
    }
    @RequestMapping("imdb/search")
    public String searchMoviePage(){
        return "searchMovie";
    }
    @RequestMapping("douban/search")
    public String searchDouPage(){
        return "searchSort";
    }
    @RequestMapping("dashboard")
    public String dashBoardPage(){
        return "dashboard";
    }
    @RequestMapping("charts")
    public String chartsPage(){
        return "charts";
    }
    @RequestMapping("platform")
    public String platFormPage(){
        return "platform";
    }
    @RequestMapping("platform1")
    public String platForm1Page(){
        return "platform1";
    }
    @RequestMapping("platform2")
    public String platForm2Page(){
        return "platform2";
    }
    @RequestMapping("platform3")
    public String platForm3Page(){
        return "platform3";
    }
    @RequestMapping("platform4")
    public String platForm4Page(){
        return "platform4";
    }
    @RequestMapping("platform5")
    public String platForm5Page(){
        return "platform5";
    }
    @RequestMapping("platform6")
    public String platForm6Page(){
        return "platform6";
    }
    @RequestMapping("login")
    public String loginPage(){
        return "login";
    }

}
