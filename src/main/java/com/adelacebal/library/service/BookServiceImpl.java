package com.adelacebal.library.service;

import com.adelacebal.library.dao.BookDao;
import com.adelacebal.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findAll() { return bookDao.findAll(); }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }
}
