package com.adelacebal.library.service;

import com.adelacebal.library.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();
    Transaction findById(Long id);
    void save(Transaction transaction);
    void delete(Transaction transaction);
}
