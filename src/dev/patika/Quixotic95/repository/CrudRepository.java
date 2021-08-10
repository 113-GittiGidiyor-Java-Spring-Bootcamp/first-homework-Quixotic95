package dev.patika.Quixotic95.repository;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();

    T findById(int id);

    T find(T object);

    void save(T object);

    void delete(int id);

    void delete(T object);

    void update(T object, int id);

}
