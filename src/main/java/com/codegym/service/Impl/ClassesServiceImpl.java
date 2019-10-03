package com.codegym.service.Impl;

import com.codegym.model.Classes;
import com.codegym.repository.ClassesRepository;
import com.codegym.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassesServiceImpl implements ClassesService {
    @Autowired
    ClassesRepository classesRepository;

    @Override
    public Iterable<Classes> findall() {
        return classesRepository.findAll();
    }

    @Override
    public Classes findById(long id) {
        return classesRepository.findOne(id);
    }

    @Override
    public void save(Classes classes) {
classesRepository.save(classes);
    }

    @Override
    public void remote(long id) {
classesRepository.delete(id);
    }
}
