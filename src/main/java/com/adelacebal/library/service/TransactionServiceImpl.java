package com.adelacebal.library.service;

import com.adelacebal.library.dao.TransactionDao;
import com.adelacebal.library.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDao transactionDao;

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
    public void delete(Transaction transaction) {
        transactionDao.delete(transaction);
    }
}
