package com.codegym.model;


import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long   id;
    private String name;

    @OneToMany(targetEntity = Student.class)
    private List<Student> students;

public Classes(){}

    public Classes(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
