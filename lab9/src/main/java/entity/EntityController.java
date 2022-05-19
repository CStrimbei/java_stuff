package entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityController {

    private static final EntityController singleton = new EntityController();

    protected EntityManagerFactory emf;

    public static EntityController getInstance() {

        return singleton;
    }

    private EntityController() {
    }

    public EntityManagerFactory getEntityManagerFactory() {

        if (emf == null)
            createEntityManagerFactory();
        return emf;
    }

    public void closeEntityManagerFactory() {

        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    protected void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("default");
    }
}