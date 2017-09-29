package com.adelacebal.library.service;

import com.adelacebal.library.dao.TransactionDao;
import com.adelacebal.library.model.Book;
import com.adelacebal.library.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    LocalDateTime now = LocalDateTime.now();
    Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    BookService bookService;

    @Override
    public List<Transaction> findAll() { return transactionDao.findAll(); }

    @Override
    public Transaction findById(Long id) {
        return transactionDao.findById(id);
    }

    @Override
    public void save(Transaction transaction) {
        transactionDao.save(transaction);
    }

    @Override
    public Long issueBook(Long id) {

        Transaction transaction = new Transaction();
        Book bookIssued = bookService.findById(id);

        if (bookIssued.getAmount() - bookIssued.getBooksIssued() > 0) {
            bookIssued.setBooksIssued(bookIssued.getBooksIssued() + 1);

            transaction.setBook(bookIssued);
            transaction.setType(true);
            transaction.setIssueDate(date);

            bookService.save(bookIssued);
            save(transaction);
        }
        return id;
    }

    @Override
    public Long returnBook(Long id) {

        Transaction returnTransaction = new Transaction();

        returnTransaction = findById(id);
        returnTransaction.setType(false);
        returnTransaction.setReturnDate(date);

        Book bookReturned = returnTransaction.getBook();
        bookReturned.setBooksIssued(bookReturned.getBooksIssued() - 1);

        save(returnTransaction);

        return bookReturned.getId();
    }
}
