package repos;

import entity.ContinentsEntity;
import entity.EntityController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ContinentRepo {

    public void create(String NAME){
        String name = NAME;
        EntityManager em = EntityController.getInstance().getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            ContinentsEntity continentEntity = new ContinentsEntity();
            continentEntity.setName(name);
            em.persist(continentEntity);
            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            EntityController.getInstance().getEntityManagerFactory().close();
        }
    }

}
