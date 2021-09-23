package com.ttsr.hibernate.dao;

import com.ttsr.hibernate.PrepareData;
import com.ttsr.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO implements DAORepository<Student, Long> {

    private final SessionFactory sessionFactory;

    private Session session;

    private Transaction transaction;

    public StudentDAO() {
        sessionFactory = PrepareData.forcePrepareData();
    }

    public Session openSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeSessionWithTransaction() {
        transaction.commit();
        session.close();
    }

    public Session openSessionWithTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session;
    }

    @Override
    public void persist(Student entity) {
        getSession().save(entity);
    }

    @Override
    public void update(Student entity) {
        getSession().update(entity);
    }

    @Override
    public Student findById(Long id) {
        return getSession().get(Student.class, id);
    }

    @Override
    public void delete(Student entity) {
        getSession().delete(entity);
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) getSession().createQuery("from Student").list();
    }

    @Override
    public void deleteAll() {
        List<Student> students = findAll();
        for (Student student : students) {
            delete(student);
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
