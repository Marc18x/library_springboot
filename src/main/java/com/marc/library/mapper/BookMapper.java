package com.marc.library.mapper;

import com.marc.library.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 查找所有书籍
     * @return
     */
    public List<Book> findAll();

    /**
     * 分页查找图书信息
     * @param start 起始数据 (page-1)*limit计算而来
     * @param limit 每页显示数量
     * @return
     */
    public List<Book> findBookListByPageAndLimit(int start,int limit);

    /**
     * 查找书籍
     * @param id
     * @return
     */
    public Book queryForBook(@Param("book_id") Integer id);

    /**
     * 增加一条新图书信息
     * @param book
     */
    public void addNewBook(Book book);

    /**
     * 删除一条图书记录
     * @param id
     */
    public void deleteBook(@Param("book_id")Integer id);

    /**
     * 更新图书记录
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 查询图书总量信息
     * @return 图书记录总量
     */
    public int selectTotalOfBook();

}
