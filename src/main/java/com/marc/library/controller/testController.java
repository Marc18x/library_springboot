package com.marc.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
/**
 * 页面的解析与跳转
 */
public class testController {

    @RequestMapping("/index")
    public String index() {
        return "/index";
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

    @RequestMapping("/bookList")
    public String bookList() {
        return "redirect:/Book/findBookList";
    }



}
