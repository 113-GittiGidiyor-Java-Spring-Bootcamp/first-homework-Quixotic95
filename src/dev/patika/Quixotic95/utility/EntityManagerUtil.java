package dev.patika.Quixotic95.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        return emf.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        em.clear();
        em.close();
        emf.close();
    }
}