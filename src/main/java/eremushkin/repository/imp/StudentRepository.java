package eremushkin.repository.imp;

import eremushkin.entity.Student;
import eremushkin.repository.AbstractEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Daniil on 10.10.2016.
 */

public class StudentRepository extends AbstractEntityRepository<Student> {

    @Transactional(propagation = Propagation.REQUIRED)
    public Student get(Long key) {
        return (Student) sessionFactory.getCurrentSession().load(Student.class, key);
    }

    public List<Student> query(String nameQuery) {
        return sessionFactory.getCurrentSession().getNamedQuery(nameQuery).list();
        /*EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<Student> typedQuery = em.createNamedQuery(nameQuery, Student.class);
        return typedQuery.getResultList();*/


    }
}