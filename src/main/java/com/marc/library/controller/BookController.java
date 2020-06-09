package com.marc.library.controller;

import com.alibaba.fastjson.JSON;
import com.marc.library.mapper.BookMapper;
import com.marc.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/Book")
public class BookController {

    @Autowired
    private BookMapper bookMapper;


    /**
     * 图书页-首页
     * @return 简单强制重定向指向index
     */
    @RequestMapping("")
    public String indexOfAll()
    {
        return "redirect:/Book/index";
    }

    @RequestMapping("/index")
    public String index()
    {
        return "/book/index";
    }

    @PostMapping("/findAllBook")
    @ResponseBody
    /**
     * 分页查找图书信息
     * @param page 当前页码
     * @param limit 每页查询量
     */
    public String findAllBook(int page,int limit)
    {
        int start = (page-1)*limit; //过滤之前的数据
        int totalOfBook = 0; //数据总量
        List<Book> bookList = bookMapper.findBookListByPageAndLimit(start,limit);
        //查询总记录数
        totalOfBook = bookMapper.selectTotalOfBook();
        String json = JSON.toJSONString(bookList);
        String demo = "{\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"\",\n" +
                "    \"count\":" + totalOfBook +
                ",\n \"data\":" + json +
                "\n" + "}";
        return demo;
    }

    /**
     *
     * @param id 检索的图书book_id
     * @return 跳转到template/bookInfo.html
     */
    @RequestMapping("/bookInfo")
    @ResponseBody
    public ModelAndView bookInfo(@RequestParam("id") Integer id)
    {
        Book book = bookMapper.queryForBook(id);
        ModelAndView modelAndView = new ModelAndView();
        //跳转的页面
        modelAndView.setViewName("/test/bookInfo");
        //添加键值对
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @RequestMapping("/insert")
    /**
     * 页面跳转- 新增书目
     */
    public String insertBook()
    {
        return "/book/add";
    }

    /**
     * 增加一条新的图书记录
     */
    @PostMapping("/add")
    @ResponseBody
    public String addBook(Book book)
    {
        bookMapper.addNewBook(book);
        return "添加成功";
    }

//    @PostMapping("/delete")

//    public String delete(@RequestParam("id")Integer id){
//        bookMapper.deleteBook(id);
//        return "redirect:findBookList";
//    }



    @RequestMapping("/delete")
    @ResponseBody
    /**
     * 前端使用ajax提交请求，保持data中key值与此处对应
     * 减少页面的跳转和数据刷新量
     * 返回删除的记录对应id
     */
    public int delete(int id) {
        //删除图书信息
        bookMapper.deleteBook(id);
        return id;
    }

    @RequestMapping("/getUpdateInfo")
    public ModelAndView getUpdateInfo(@RequestParam("id")Integer id)
    {
        Book book = bookMapper.queryForBook(id);
        ModelAndView modelAndView = new ModelAndView();
        //跳转的页面
        modelAndView.setViewName("/test/bookUpdate");
        //添加键值对
        modelAndView.addObject("book",book);
        return modelAndView;

    }


    /**
     * 更新图书信息
     */
    @PostMapping("update")
    public String update(@RequestParam("book_id") Integer book_id,
                         @RequestParam("name") String name,
                         @RequestParam("author") String author,
                         @RequestParam("publish") String publish,
                         @RequestParam("isbn") String ISBN,
                         @RequestParam("introduction") String introduction,
                         @RequestParam("language") String language,
                         @RequestParam("price") Double price,
                         @RequestParam("pub_date")Date pub_date,
                         @RequestParam("class_id")Integer class_id,
                         @RequestParam("number")Integer number){
        Book book = new Book(book_id,name,author,publish,ISBN,introduction,language,price,pub_date,class_id,number);
        bookMapper.updateBook(book);
        return "redirect:findBookList";
    }





}
