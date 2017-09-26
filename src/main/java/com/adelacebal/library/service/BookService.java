package com.adelacebal.library.service;

import com.adelacebal.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    void delete(Book book);
}
