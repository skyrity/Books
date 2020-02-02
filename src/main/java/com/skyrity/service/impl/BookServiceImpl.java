package com.skyrity.service.impl;

import com.skyrity.Data;
import com.skyrity.bean.Book;
import com.skyrity.service.BookService;
import com.skyrity.utils.ComUtil;
import com.skyrity.utils.RetCode;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ： VULCAN
 * @date ：2020/02/02 12:39
 * @description : ${description}
 * @path : com.skyrity.service.impl.BookServiceImpl
 */

@Service("BookService")
public class BookServiceImpl implements BookService{

    private Data data=new Data();
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public List<Book> getAllBooks() {
        return data.getBooks();
    }

    @Override
    public long addBook(Book book) {
        long ret=0;
        //检查书名称
        if(data.checkBook(book.getName())){
            return ret;
        }

        //Book book=new Book();
        book.setId(data.getBookMax()+1);
        //book.setName(name);
        book.setCreateDate(sdf.format(new Date()));

        data.getBooks().add(book);
        return book.getId();
    }

    @Override
    public Book checkBook(String name) {
        List<Book> books=data.getBooks();
        for (Book book : books) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        return null;

    }

    @Override
    public Book getBook(int id) {
        List<Book> books=data.getBooks();
        for (Book book : books) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;

    }

    @Override
    public Book editBook(int id, String name) {

        List<Book> books=data.getBooks();
        for (Book book : books) {
            if (id == book.getId()) {
                book.setName(name);
                book.setCreateDate(sdf.format(new Date()));
                JSONObject jsonObject = JSONObject.fromObject(book);
                return book;
            }
        }
        return null;
    }

    @Override
    public Book deleteBook(int id) {
        List<Book> books=data.getBooks();
        Book book=null;
        for(int i=0;i<books.size();i++){
            if(id==books.get(i).getId()){
                book=books.get(i);
                books.remove(i);
                return book;
            }
        }
        return null;
    }
}
