package repos;

import entity.ContinentsEntity;
import entity.EntityController;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
        }
    }

    public void findById(int ID){
        int id = ID;
        EntityManager em = EntityController.getInstance().getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            TypedQuery<String> findId = em.createNamedQuery("conti.findid", String.class);
            findId.setParameter(1, id);
            for (String nameq : findId.getResultList()) {
                System.out.println(nameq);
            }
            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }

    public void findByName(String NAME){
        String name = NAME;
        EntityManager em = EntityController.getInstance().getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            TypedQuery<String> findId = em.createNamedQuery("conti.findname", String.class);
            findId.setParameter(1, name);
            for (String nameq : findId.getResultList()) {
                System.out.println(nameq);
            }
            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }

}
