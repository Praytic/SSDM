package eremushkin.repository.imp;

import eremushkin.entity.Mark;
import eremushkin.repository.AbstractEntityRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniil on 24.10.2016.
 */
public class MarkRepository extends AbstractEntityRepository<Mark> {

    @Transactional(propagation = Propagation.REQUIRED)
    public Mark get(long key) {
        return (Mark) sessionFactory.getCurrentSession().load(Mark.class, key);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Mark> query(String nameQuery) {
        return sessionFactory.getCurrentSession().getNamedQuery(nameQuery).list();
    }
}
