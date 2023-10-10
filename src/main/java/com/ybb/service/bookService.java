package com.ybb.service;

import com.ybb.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface bookService {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBooksById(int id);
    //查新全部书
    List<Books> queryBookAll();
    //查询书籍
    List<Books> queryBookAll1(String name);
}
