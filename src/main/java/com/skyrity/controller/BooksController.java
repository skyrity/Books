package com.skyrity.controller;

import com.skyrity.bean.Book;
import com.skyrity.service.BookService;
import com.skyrity.utils.ComUtil;
import com.skyrity.utils.RetCode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ： macai
 * @date ：2020/02/01 11:32
 * @description : 图书管理访问接口入口
 * @path : com.skyrity.controller.BooksController
 */
@Controller
@RequestMapping("/books")
public class BooksController {


    @Autowired
    BookService bookService;
    /**
     * 获得所有图书
     * @param response 响应对象
     */
    @RequestMapping(value="",method= RequestMethod.GET)
    public void getAllBooks(HttpServletResponse response){
      response.setContentType("application/json;charset=utf-8");
      List<Book> books=bookService.getAllBooks();
      JSONArray jsonData= JSONArray.fromObject(books);
      ComUtil.printWrite(response,jsonData.toString());

  }

    /**
     * 增加图书
     * @param book  图书对象
     * @param response 响应对象
     */
    @RequestMapping(value="",method= RequestMethod.POST)
    public void addBook(@RequestBody Book book, HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        //检查参数
        //String name=request.getParameter("name");
        if(book==null ){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR));
            return ;
        }

        long ret=bookService.addBook(book);
        if(ret==0){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR_BOOKNAME));
        }else{
           JSONObject jsonObject = JSONObject.fromObject(book);
           ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_SUCCESS.replace("RESULT_DATA",jsonObject.toString())));
        }


    }

    /**
     * 检查图书名称
     * @param name 图书名称
     * @param response 响应对象
     */
    @RequestMapping(value="/book/{name}",method= RequestMethod.GET)
    public void checkBook(@PathVariable("name") String name, HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        //检查参数
        if(name==null || "".equals(name) ){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR));
            return ;
        }
        Book book=bookService.checkBook(name);
        if(book==null){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_SUCCESS.replace("RESULT_DATA", "{\"flag\":false}")));
        }else {
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_SUCCESS.replace("RESULT_DATA", "{\"flag\":true}")));
        }
    }

    /**
     * 获得指定ID的图书对象
     * @param id 图书id
     * @param response 响应对象
     */
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public void getBook(@PathVariable("id") Integer  id,HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");

        Book book=bookService.getBook(id);
        if(book==null){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR_NOTFOUND));
        }else{
            JSONObject jsonObject = JSONObject.fromObject(book);
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_SUCCESS.replace("RESULT_DATA", jsonObject.toString())));
        }

    }

    /**
     * 编辑图书
     * @param id 图书id
     * @param book 图书对象
     * @param response 响应对象
     */
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public void editBook(@PathVariable("id") Integer id,@RequestBody Book book,  HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");

        //检查参数
        if(book==null ){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR));
            return ;
        }

        Book book1=bookService.editBook(id,book.getName());
        if(book1==null){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR_NOTFOUND));
        }else{
            JSONObject jsonObject = JSONObject.fromObject(book1);
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_SUCCESS.replace("RESULT_DATA", jsonObject.toString())));
        }

    }

    /**
     * 删除图书
     * @param id 图书id
     * @param response 响应对象
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") Integer id,HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        //检查参数
        if(id==0 ){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR));
            return ;
        }
        Book book=bookService.deleteBook(id);
        if(book==null){
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_ERROR_NOTFOUND));
        }else{
            JSONObject jsonObject = JSONObject.fromObject(book);
            ComUtil.printWrite(response, ComUtil.getResultTime(RetCode.RET_SUCCESS.replace("RESULT_DATA", jsonObject.toString())));
        }

    }
}
