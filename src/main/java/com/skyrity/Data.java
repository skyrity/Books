package com.skyrity;

import com.skyrity.bean.Book;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ： VULCAN
 * @date ：2020/02/01 11:39
 * @description : ${description}
 * @path : com.skyrity.Data
 * @modifiedBy ：
 */
public class Data {
    public List<Book> books=new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Data() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Book book=new Book();
        book.setId(1);
        book.setName("test01");
        book.setCreateDate(sdf.format(new Date()));
        books.add(book);

        book=new Book();
        book.setId(2);
        book.setName("test02");
        book.setCreateDate(sdf.format(new Date()));
        books.add(book);

        book=new Book();
        book.setId(3);
        book.setName("test03");
        book.setCreateDate(sdf.format(new Date()));
        books.add(book);

        book=new Book();
        book.setId(4);
        book.setName("test04");
        book.setCreateDate(sdf.format(new Date()));
        books.add(book);

    }

    public int getBookMax(){

       int max=0;
       if(books.size()==0){
           return max;
       }
       max=books.get(0).getId();
       for(int i=1;i<books.size();i++){
           if(max<books.get(i).getId()){
               max=books.get(i).getId();
           };
       }
       return max;

    }
    public Boolean checkBook(String name){

        for(int i=0;i<books.size();i++){
            if(name.equals(books.get(i).getName())){
                return true;
            };
        }
        return false;
    }

}
