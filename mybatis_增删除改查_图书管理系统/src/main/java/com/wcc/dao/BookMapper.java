package com.wcc.dao;

import com.wcc.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//mapper 类
@Mapper
@Repository
public interface BookMapper {
    // 增加一本书
    int addBook(Book book);
    // 删除一本书
    int deleteBookById(int id);
    // 更新一本书
    int updateBook(Book book);
    // 查询一本书
    Book queryBookById(int id);
    // 查询全部的书
    List<Book> queryAllBook();
}
