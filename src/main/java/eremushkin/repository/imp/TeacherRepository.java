package eremushkin.repository.imp;

import eremushkin.entity.Teacher;
import eremushkin.repository.AbstractEntityRepository;

import java.util.List;

/**
 * Created by Daniil on 24.10.2016.
 */
public class TeacherRepository extends AbstractEntityRepository<Teacher> {

    public Teacher get(long key) {
        return (Teacher) sessionFactory.getCurrentSession().load(Teacher.class, key);
    }

    public List<Teacher> query(String nameQuery) {
        return sessionFactory.getCurrentSession().getNamedQuery(nameQuery).list();
    }
}
