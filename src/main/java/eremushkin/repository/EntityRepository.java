package eremushkin.repository;
import java.util.List;

public interface EntityRepository<T, K> {
    void add(T entity);
    void delete(K key);
    T get(K key);
    void update(T entity);
    List<T> query(String nameQuery);
}
