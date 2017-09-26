package com.adelacebal.library.dao;

import com.adelacebal.library.model.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Transaction> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Transaction> criteria = builder.createQuery(Transaction.class);
        criteria.from(Transaction.class);
        List<Transaction> transactions = session.createQuery(criteria).getResultList();
        session.close();

        return transactions;
    }

    @Override
    public Transaction findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.get(Transaction.class, id);
        Hibernate.initialize(transaction.getBook());
        session.close();
        return transaction;
    }

    @Override
    public void save(Transaction transaction) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(transaction);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Transaction transaction) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(transaction);
        session.getTransaction().commit();
        session.close();
    }
}
