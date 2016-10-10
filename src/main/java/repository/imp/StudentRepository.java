package repository.imp;

import entity.Student;
import repository.AbstractEntityRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Daniil on 10.10.2016.
 */
public class StudentRepository extends AbstractEntityRepository<Student> {

    public Student get(Long key) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(Student.class, key);
    }

    public List<Student> query(String nameQuery) {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<Student> typedQuery = em.createNamedQuery(nameQuery, Student.class);
        return typedQuery.getResultList();

    }
}
