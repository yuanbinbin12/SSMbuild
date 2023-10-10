package com.ybb.mapper;

import com.ybb.pojo.Books;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bookMapper {
    //增加一本书
    @Insert("insert into books (bookName,bookCounts,detail) value (#{bookName},#{bookCounts},#{detail})")
    int addBook(Books books);
    //删除一本书
    @Delete("delete from books where bookid=#{id}")
    int deleteBookById(@Param("id") int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBooksById(@Param("bookId") int id);
    //查新全部书
    @Select("select * from books")
    List<Books> queryBookAll();
    @Select("select * from books where bookName like #{bookName} or bookId like #{bookId} or detail like #{bookName}")
    List<Books> queryBookAll1(@Param("bookName") String name,@Param("bookId") int bookId);
}
