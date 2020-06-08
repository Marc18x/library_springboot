package com.marc.library.controller;

import com.marc.library.mapper.AdminMapper;
import com.marc.library.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/")
    public String indexOfAll(){
        return "redirect:/index";
    }

    /**
     * 引入thymeleaf组件，返回页面指向templates下页面
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/hello")
    public String hello(@RequestParam("username")String username,
                              @RequestParam("password")String password)
    {
        System.out.println(username+"/"+password);
        Admin admin = adminMapper.queryForAdmin(username,password);
        ModelAndView modelAndView = new ModelAndView();
//        //跳转的页面
//        modelAndView.setViewName("hello");
//        //添加键值对
//        modelAndView.addObject("key", username+"/"+password+"输入的用户名对应的id");
//        modelAndView.addObject("admin", admin);
//        //System.out.println("test");
//        return modelAndView;
        return "redirect:/Book/index";
    }

    /**
     * 返回首页 templates/index.html 后续需要根据角色返回不同的页面
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/test")
    public String test() {
        return "/test";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/charts")
    public String chats() {
        return "/test/charts";
    }

    @RequestMapping("/tables")
    public String tables() {
        return "/test/tables";
    }

    @RequestMapping("/forms")
    public String forms() {
        return "/test/forms";
    }

    @RequestMapping("/findAllBooks")
    public String finaAllBooks() {
        return "redirect:/test/bookList";
    }

}
