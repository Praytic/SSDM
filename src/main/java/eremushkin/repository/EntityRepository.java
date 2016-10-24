package eremushkin.repository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EntityRepository<T> {
    void add(T entity);
    void delete(long key);
    T get(long key);
    void update(T entity);
    List<T> query(String nameQuery);
}
