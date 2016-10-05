package EntityManager;

import Entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Daniil on 05.10.2016.
 */
public class StudentManager {
    public EntityManager em = Persistence.createEntityManagerFactory("Eremushkin").createEntityManager();

    public Student add(Student student){
        em.getTransaction().begin();
        Student studentFromBD = em.merge(student);
        em.getTransaction().commit();
        return studentFromBD;
    }

    public void delete(long studentId){
        em.getTransaction().begin();
        em.remove(get(studentId));
        em.getTransaction().commit();
    }

    public Student get(long studentId){
        return em.find(Student.class, studentId);
    }

    public void update(Student student){
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public List<Student> getAll(){
        TypedQuery<Student> namedQuery = em.createNamedQuery("Student.getAll", Student.class);
        return namedQuery.getResultList();
    }

}
