package com.example.crazyandroid.com.example.fourth;

import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookContent {
    //定义一个内部类，作为系统的业务对象
    public  static  class Book{
        public  Integer id;
        public  String title;
        public  String desc;
        public  Book( Integer id,String title,String desc){
            this.id=id;
            this.title=title;
            this.desc=desc;

        }

        @Override
        public String toString() {
            return title;
        }
    }
    //使用了list集合记录系统所包含的book对象
    public  static List<Book> ITEMS=new ArrayList<Book>();
    //使用Map集合记录系统所包含的Book对象
    public  static Map<Integer,Book> ITEM_MAP=new HashMap<Integer, Book>();

    static {
        //使用静态初始化代码，将Book对象添加到List集合，map集合中
        AddItem(new Book(1,"疯狂java讲义","一本全面、深入的JAVA学习图书，已被多家高校选做教材"));
        AddItem(new Book(2,"疯狂Android讲义","Android学习者的首选图书畅销排行榜榜首"));
        AddItem(new Book(3,"轻量级JAVA EE企业级应用实战","全面杰嫂"));

    }

    private  static  void AddItem(Book book){
        ITEMS.add(book);
        ITEM_MAP.put(book.id,book);
    }

}
