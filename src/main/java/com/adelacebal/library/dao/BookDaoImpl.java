package com.adelacebal.library.dao;

import com.adelacebal.library.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
        criteria.from(Book.class);
        List<Book> books = session.createQuery(criteria).getResultList();
        session.close();
        return books;
    }

    @Override
    public Book findById(Long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
//        Hibernate.initialize(book.getTransactions());
        session.close();
        return book;
    }

    @Override
    public void save(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }

}
