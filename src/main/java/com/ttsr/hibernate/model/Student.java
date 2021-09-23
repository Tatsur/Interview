package com.ttsr.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int mark;

    public Student(Long id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }
}
