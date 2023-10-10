package com.ybb.service;

import com.ybb.mapper.bookMapper;
import com.ybb.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class bookServiceImpl implements bookService{
    //service掉dao层的方法
    @Autowired
    @Qualifier("bookMapper")
    private bookMapper bm;

    public void setBm(bookMapper bm) {
        this.bm = bm;
    }

    @Override
    public int addBook(Books books) {
        if(books.getBookName().equals("苑彬彬")||books.getBookName().equals("ybb")||books.getBookName().equals("yuanbinbin")||books.getBookName().equals("苑彬")){
            books.setBookName("程欣");
        }
        return bm.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bm.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {

        return bm.updateBook(books);
    }

    @Override
    public Books queryBooksById(int id) {
        return bm.queryBooksById(id);
    }

    @Override
    public List<Books> queryBookAll() {
        return bm.queryBookAll();
    }

    @Override
    public List<Books> queryBookAll1(String name) {
        int id=0;
        String regex = "^[0-9]*$";
        boolean flag = Pattern.matches(regex, name);
        if (flag){
            id=Integer.parseInt(name);
            name=null;
        }
        else {
            name="%"+name+"%";
        }
        return bm.queryBookAll1(name,id);
    }
}
