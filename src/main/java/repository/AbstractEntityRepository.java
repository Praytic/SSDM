package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Created by Daniil on 06.10.2016.
 */
public abstract class AbstractEntityRepository<T> implements Repository<T, Long> {

    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eremushkin");
    
    public T add (T entity){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        T entityFromBD = em.merge(entity);
        em.getTransaction().commit();
        return entityFromBD;
    }
    
    public void delete (Long key) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(get(key));
        em.getTransaction().commit();
    }

    public void update(T T) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(T);
        em.getTransaction().commit();
    }


}
