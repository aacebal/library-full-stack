package com.adelacebal.library.web.controller;

import com.adelacebal.library.model.Book;
import com.adelacebal.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.LIBRARY_V1)
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> getAllBooks() {
        List<Book> books = bookService.findAll();

        return books;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> addBook(Book book) {
        bookService.save(book);
        List<Book> books = bookService.findAll();

        return books;
    }

    @RequestMapping(value = "/book/details/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Book bookDetails(@PathVariable Long bookId) {
        Book book = bookService.findById(bookId);

        return book;
    }

    @RequestMapping(value = "book/delete/{bookId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> deleteBook(@PathVariable Long bookId) {
        Book book = bookService.findById(bookId);
        bookService.delete(book);

        List<Book> books = bookService.findAll();
        return books;
    }
}
