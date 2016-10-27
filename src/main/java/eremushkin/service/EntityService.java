package eremushkin.service;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Daniil on 26.10.2016.
 */
public interface EntityService<T> {

    T addBank(T t);
    void delete(long id);
    T getById(long id);
    T edit(T t);
    List<T> getAll();
}
