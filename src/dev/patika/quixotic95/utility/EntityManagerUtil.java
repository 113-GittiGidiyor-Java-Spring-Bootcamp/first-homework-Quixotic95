package dev.patika.quixotic95.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    static EntityManagerFactory entityManagerFactory = null;

    public static EntityManager getEntityManager(String persistenceUnitName) {
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager entityManager) {
        entityManager.clear();
        entityManager.close();
        entityManagerFactory.close();
    }
}
