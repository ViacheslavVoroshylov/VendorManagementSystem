package com.khai.voroshylov.dao;

import java.util.List;

public interface AbstractDao<T, ID> {

    T getById(ID id);
    List<T> getAll();
    T save(T t);
    T update(T t);
    void deleteById(ID id);
}
