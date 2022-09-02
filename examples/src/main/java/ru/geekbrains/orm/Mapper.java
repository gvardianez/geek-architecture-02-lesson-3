package ru.geekbrains.orm;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Mapper<T extends Entity> {

    Optional<T> findById(Long id);

    Map<Long, T> getIdentityMap();

    Optional<T> findByString(String s);

    Connection getConn();

    void update(List<T> entities);

    void update(T entity);

    void insert(List<T> entities);

    Optional<T> insert (T entity);

    void delete(List<T> entities);

    void delete(T entity);

}
