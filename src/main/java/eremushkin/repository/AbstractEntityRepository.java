package eremushkin.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import eremushkin.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class AbstractEntityRepository<T> implements EntityRepository<T, Long> {

    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public abstract T get(Long key);
    public abstract  List<T> query(String nameQuery);

    @Transactional(propagation = Propagation.REQUIRED)
    public void add (T entity){
        sessionFactory.getCurrentSession().save(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete (Long key) {
        T entiy = get(key);
        if(entiy != null)
            sessionFactory.getCurrentSession().delete(entiy);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }


}
