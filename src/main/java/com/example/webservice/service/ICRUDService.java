package com.example.webservice.service;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<E,T> {
    E save(E e);

    void delete(T id);

    Optional<E> findById(T id);

    List<E> findAll();
}
