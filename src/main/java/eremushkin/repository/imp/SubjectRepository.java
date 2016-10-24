package eremushkin.repository.imp;

import eremushkin.entity.Subject;
import eremushkin.repository.AbstractEntityRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniil on 24.10.2016.
 */
public class SubjectRepository extends AbstractEntityRepository<Subject> {

    @Transactional(propagation = Propagation.REQUIRED)
    public Subject get(long key) {
        return (Subject) sessionFactory.getCurrentSession().load(Subject.class, key);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Subject> query(String nameQuery) {
        return sessionFactory.getCurrentSession().getNamedQuery(nameQuery).list();
    }
}
