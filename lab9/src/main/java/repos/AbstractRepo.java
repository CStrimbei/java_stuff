package repos;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class AbstractRepo {
    public void create(AbstractEntity entity){
        if(entity instanceof ContinentsEntity){
            String name = ((ContinentsEntity) entity).getName();
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
        if(entity instanceof CountriesEntity){
            String name = ((CountriesEntity) entity).getName();
            String code = ((CountriesEntity) entity).getCode();
            int idforeign = ((CountriesEntity) entity).getContinentId();
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
        if(entity instanceof CitiesEntity){
            EntityManager em = EntityController.getInstance().getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try{
                transaction.begin();
                CitiesEntity cityEntity = new CitiesEntity();
                cityEntity.setName(((CitiesEntity) entity).getName());
                cityEntity.setCountryId(((CitiesEntity) entity).getCountryId());
                cityEntity.setHascapital(((CitiesEntity) entity).getHascapital());
                cityEntity.setLatitude(((CitiesEntity) entity).getLatitude());
                cityEntity.setLongitude(((CitiesEntity) entity).getLongitude());
                em.persist(cityEntity);
                transaction.commit();
            } finally {
                if(transaction.isActive()){
                    transaction.rollback();
                }
                em.close();
            }
        }
    }
    public void findCityById(int ID){
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
    public void findCityByName(String NAME){
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
    public void findCountryById(int ID){
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
    public void findCountryByName(String NAME){
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
    public void findContinentById(int ID){
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
    public void findContinentByName(String NAME){
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
