package com.marc.library.controller;

import com.marc.library.mapper.AdminMapper;
import com.marc.library.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapperController {

    @Autowired
    private AdminMapper adminMapper;
    /**
     *登录鉴权 RequestMapping 相对地址 相对于root目录下
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public Admin queryForAdmin(){
       Admin admin = adminMapper.queryForAdmin("admin","123456");
       return  admin;

    }


}
