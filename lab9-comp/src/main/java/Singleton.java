import entity.ContinentsEntity;
import model.Continent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
    private static Singleton single_instance = null;
    public static Singleton getInstance(){
        if(single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    public void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Continent continent = new Continent("Europe");
        em.persist(continent);

        Continent c = (Continent)em.createQuery(
                        "select e from ContinentsEntity e where e.name='Europe'")
                .getSingleResult();
        c.setName("Africa");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
