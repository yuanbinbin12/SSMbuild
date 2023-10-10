package com.ybb.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.ybb.pojo.Books;
import com.ybb.pojo.Word;
import com.ybb.service.bookService;
import com.ybb.service.noWordService;
import com.ybb.service.noWordServiceImpl;
import com.ybb.utils.noword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.util.List;

@Controller
public class bookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private bookService bookService;
    @Autowired
    private noword nw;
    @RequestMapping("/book/addBook")
    public String addBook(){
        return "addBook";
    }
    @RequestMapping("/book/allBook")
    public String listBooks(Model model){
        List<Books> books = bookService.queryBookAll();
        model.addAttribute("allBooks",books);
        return "allBook";
    }
    @RequestMapping("/book/allBook8080")
    @ResponseBody
    public String listBooksALL(Model model){
        List<Books> books = bookService.queryBookAll();
        String s = JSON.toJSONString(books);
        System.out.println(s);
        return s;
    }
    @RequestMapping("/book/toAddBook")
    public String toAddBook(Books books, HttpServletRequest request){
        System.out.println("books==>"+books);
        books = nw.nowordMethod(books);
        bookService.addBook(books);
        String url= String.valueOf(request.getRequestURL());
        System.out.println("url为"+ url);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/book/toUpdateBook/{bookID}")
    public String updateBook(@PathVariable int bookID,Model model){
        Books books = bookService.queryBooksById(bookID);
        model.addAttribute("updateBook",books);
        return "updateBook";
    }
    @RequestMapping("/book/updateBook/{bookID}")
    public String updateBooks(Books book,@PathVariable int bookID){
        book.setBookID(bookID);
        System.out.println(book);
        book = nw.nowordMethod(book);
        int i = bookService.updateBook(book);
        if (i!=0) {
            return "redirect:/book/allBook";
        }
        else{
            return "updateBook";
        }
    }
    @RequestMapping("/book/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id){
        int i = bookService.deleteBookById(id);
        if (i!=0) {
            return "redirect:/book/allBook";
        }
        else{
            return "forward:index.jsp";
        }
    }
    //查询书籍
    @RequestMapping("/book/selectByAll")
    public String queryBooks(String queryBookName,Model model){
        model.addAttribute("msg","");
        List<Books> books = bookService.queryBookAll1(queryBookName);
        if (books.size()==0){
            model.addAttribute("msg","查询结果为空");
            return "forward:/book/allBook";
        }
        else {
            model.addAttribute("allBooks", books);
            return "allBook";
        }
    }
}
