package repository;
import java.util.List;

public interface Repository<T, K> {
    T add(T t);
    void delete(K key);
    T get(K key);
    void update(T t);
    List<T> query(String nameQuery);
}
