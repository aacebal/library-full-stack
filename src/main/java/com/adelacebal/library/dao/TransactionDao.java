package com.adelacebal.library.dao;

import com.adelacebal.library.model.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> findAll();
    Transaction findById(Long id);
    void save(Transaction transaction);
//    void delete(Transaction transaction);
}
