package repos;

import entity.ContinentsEntity;
import entity.CountriesEntity;
import entity.EntityController;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class CountryRepo {
    public void create(String NAME, String CODE, int idfk){
        String name = NAME;
        String code = CODE;
        int idforeign = idfk;
        EntityManager em = EntityController.getInstance().getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            CountriesEntity countryEntity = new CountriesEntity();
            countryEntity.setName(name);
            countryEntity.setCode(code);
            countryEntity.setContinentId(idforeign);
            em.persist(countryEntity);
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
            TypedQuery<String> findId = em.createNamedQuery("count.findid", String.class);
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
            TypedQuery<String> findId = em.createNamedQuery("count.findname", String.class);
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
