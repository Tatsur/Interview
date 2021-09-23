package com.ttsr.hibernate.service;

import com.ttsr.hibernate.dao.StudentDAO;
import com.ttsr.hibernate.model.Student;

import java.util.List;

public class StudentService {
    private static StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public void persist(Student entity){
        studentDAO.openSessionWithTransaction();
        studentDAO.persist(entity);
        studentDAO.closeSessionWithTransaction();
    }

    public void update(Student entity){
        studentDAO.openSessionWithTransaction();
        studentDAO.update(entity);
        studentDAO.closeSessionWithTransaction();
    }

    public Student findById(Long id){
        studentDAO.openSession();
        Student student = studentDAO.findById(id);
        studentDAO.closeSession();
        return student;
    }

    public void delete(Long id){
        studentDAO.openSessionWithTransaction();
        Student student = studentDAO.findById(id);
        studentDAO.delete(student);
        studentDAO.closeSessionWithTransaction();
    }

    public List<Student> findAll(){
        studentDAO.openSession();
        List<Student> students = studentDAO.findAll();
        studentDAO.closeSession();
        return students;
    }

    public void deleteAll(){
        studentDAO.openSessionWithTransaction();
        studentDAO.deleteAll();
        studentDAO.closeSessionWithTransaction();
    }

    public StudentDAO studentDAO(){
        return studentDAO;
    }
}
