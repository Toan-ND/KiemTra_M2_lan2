package com.codegym.model;


import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
    private String name;
    private String birthdate;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    public Student(){}

    public Student(String name, String birthdate, Classes classes) {
        this.name = name;
        this.birthdate = birthdate;
        this.classes = classes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
