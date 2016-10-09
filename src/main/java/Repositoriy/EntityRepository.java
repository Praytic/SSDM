package Repositoriy;




import java.util.List;

/**
 * Created by Daniil on 06.10.2016.
 */
public interface EntityRepository <T, K> {
    T add(T t);
    void delete(K key);
    T get(K key);
    void update(T t);
    List<T> query(String nameQuery);
}
