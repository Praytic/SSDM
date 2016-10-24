package eremushkin.repository.imp;

import eremushkin.entity.Group;
import eremushkin.repository.AbstractEntityRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniil on 24.10.2016.
 */
public class GroupRepository extends AbstractEntityRepository<Group> {

    @Transactional(propagation = Propagation.REQUIRED)
    public Group get(long key) {
        return (Group) sessionFactory.getCurrentSession().load(Group.class, key);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Group> query(String nameQuery) {
        return sessionFactory.getCurrentSession().getNamedQuery(nameQuery).list();
    }
}
