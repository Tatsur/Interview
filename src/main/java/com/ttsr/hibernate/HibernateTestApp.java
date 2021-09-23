package com.ttsr.hibernate;

import com.ttsr.hibernate.model.Student;
import com.ttsr.hibernate.service.StudentService;

import java.util.List;
import java.util.Random;

public class HibernateTestApp {
    public static StudentService studentService;
    public static void main(String[] args) {
        studentService = new StudentService();
        Random random = new Random();
        System.out.println("start persist");
        for (int i = 0; i < 1000; i++) {
            studentService.persist(new Student("Student"+i,1 + random.nextInt(10)));
        }
        print("init students");
        studentService.delete(1L);
        print("delete");
        Student student = studentService.findById(3L);
        System.out.println("student found by id"+ student);
        student.setName("Updated Student");
        studentService.update(student);
        print("update");
        studentService.deleteAll();
        print("delete all");
    }

    public static void print(String text){
        System.out.printf("---------%s---------%n",text);
        studentService.findAll().forEach(System.out::println);
    }
}
