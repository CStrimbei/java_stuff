package entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityController {

    public static final boolean DEBUG = false;

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
            if (DEBUG)
                System.out.println("n*** Persistence finished at " + new java.util.Date());
        }
    }

    protected void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("default");
        if (DEBUG)
            System.out.println("n*** Persistence started at " + new java.util.Date());
    }
}