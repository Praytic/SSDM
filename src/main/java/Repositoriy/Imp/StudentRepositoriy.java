package Repositoriy.Imp;


import Entity.Student;
import Repositoriy.EntityRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by Daniil on 06.10.2016.
 */
public abstract class StudentRepositoriy implements EntityRepository<Student, Long>{
    private EntityManager em = Persistence.createEntityManagerFactory("Eremushkin").createEntityManager();

    public Student add (Student entity){
        em.getTransaction().begin();
        Student entityFromBD = em.merge(entity);
        em.getTransaction().commit();
        return entityFromBD;
    }

    public void delete (Long key) {
        em.getTransaction().begin();
        em.remove(get(key));
        em.getTransaction().commit();
    }

    public Student get (Long key) {
        return em.find(Student.class, key);
    }

    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public List<Student> query(String nameQuery) {
        TypedQuery<Student> typedQuery = em.createNamedQuery(nameQuery, Student.class);
        return typedQuery.getResultList();
    }
}
