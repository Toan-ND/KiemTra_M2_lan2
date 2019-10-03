package com.codegym.service;

import com.codegym.model.Student;

public interface StudentService {

    Iterable<Student> findAll();

    Student findById(long id);

    void save(Student student);

    void remote(long id);
}
