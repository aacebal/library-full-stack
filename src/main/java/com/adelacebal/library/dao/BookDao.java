package com.adelacebal.library.dao;

import com.adelacebal.library.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    void delete(Book book);
}
