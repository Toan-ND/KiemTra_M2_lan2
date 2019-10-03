package com.codegym.service;

import com.codegym.model.Classes;

public interface ClassesService {
    Iterable<Classes>findall();

    Classes findById(long id);

    void save(Classes classes);

    void remote(long id);

}
