package com.skyrity.service;

import com.skyrity.bean.Book;

import java.util.List;

/**
 * @author ： VULCAN
 * @date ：2020/02/02 12:35
 * @description : ${description}
 * @path : com.skyrity.service.BookService
 * @modifiedBy ：
 */
public interface BookService {
    //获得所有图书
    List<Book> getAllBooks();
    //增加图书
    long addBook(Book book);
    //检查图书名称
    Book checkBook(String name);
    //获得指定ID的图书对象
    Book getBook(int id);
    //编辑图书
    Book editBook(int id,String name);
    //删除图书
    Book deleteBook(int id);
}
