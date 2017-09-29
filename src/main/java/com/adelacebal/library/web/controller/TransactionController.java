package com.adelacebal.library.web.controller;

import com.adelacebal.library.model.Transaction;
import com.adelacebal.library.service.BookService;
import com.adelacebal.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(ControllerConstants.LIBRARY_V1)
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/transactions/{bookId}", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<Transaction> getTransactions(Long bookId) {

        ArrayList<Transaction> bookTransactions = new ArrayList<>();

        transactionService.findAll().forEach((transaction -> {
            System.out.println("ONE TRANSACTION ------> " + transaction);
            System.out.println("IDS ---------> " + transaction.getBook().getId());
            if (transaction.getBook().getId().equals(bookId)) {

                bookTransactions.add(transaction);
            }
        }));

        return bookTransactions;
    }

}



