package com.adelacebal.library.web.controller;

import com.adelacebal.library.model.Transaction;
import com.adelacebal.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(ControllerConstants.LIBRARY_V1)
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    @Autowired
    TransactionService transactionService;


    @RequestMapping(value = "/transactions/issue/{bookId}", method = RequestMethod.POST, produces = "application/json")
    public ArrayList<Transaction> newTransaction(@PathVariable Long bookId) {

        return getTransactions(transactionService.issueBook(bookId));

    }

    @RequestMapping(value = "/transactions/return/{transactionId}", method = RequestMethod.POST, produces = "application/json")
    public ArrayList<Transaction> closeTransaction(@PathVariable Long transactionId) {

         return getTransactions(transactionService.returnBook(transactionId));
    }

    @RequestMapping(value = "/transactions/{bookId}", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<Transaction> getTransactions(@PathVariable Long bookId) {

        ArrayList<Transaction> bookTransactions = new ArrayList<>();

        transactionService.findAll().forEach((transaction -> {
            if (transaction.getBook().getId().equals(bookId)) {

                bookTransactions.add(transaction);
            }
        }));

        return bookTransactions;
    }

}



