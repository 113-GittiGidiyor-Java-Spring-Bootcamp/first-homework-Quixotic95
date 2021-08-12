package dev.patika.quixotic95.repository;

import java.util.List;

public interface CrudRepository<T> {

    T findById(int id);

    List<T> findAll();

    void save(T object);

    void deleteById(int id);

    void delete(T object);

    void update(T object, int id);

}
