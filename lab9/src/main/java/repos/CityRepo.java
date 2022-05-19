package repos;

import entity.CitiesEntity;
import entity.CountriesEntity;
import entity.EntityController;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class CityRepo {
    public void create(String NAME, int idfk, boolean hasCapital, double latitude, double longitude){
        EntityManager em = EntityController.getInstance().getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            CitiesEntity cityEntity = new CitiesEntity();
            cityEntity.setName(NAME);
            cityEntity.setCountryId(idfk);
            cityEntity.setHascapital(hasCapital);
            cityEntity.setLatitude(latitude);
            cityEntity.setLongitude(longitude);
            em.persist(cityEntity);
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
            TypedQuery<String> findId = em.createNamedQuery("city.findid", String.class);
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
            TypedQuery<String> findId = em.createNamedQuery("city.findname", String.class);
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
