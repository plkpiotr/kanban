package com.plkpiotr.kanban.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Specifies operation of database.
 */
@WebListener()
public class ConfigurationListener implements ServletContextListener {
    private static EntityManagerFactory entityManagerFactory;

    /**
     * Configures data connected with database during launching application.
     */
    public void contextInitialized(ServletContextEvent sce) {
        entityManagerFactory = Persistence.createEntityManagerFactory("KanbanUnit");
    }

    /**
     * Configures data connected with database during shutting down application.
     */
    public void contextDestroyed(ServletContextEvent sce) {
        if (entityManagerFactory != null && entityManagerFactory.isOpen())
            entityManagerFactory.close();
    }

    /**
     * Creates manager of entities for factory manager's of entities.
     *
     * @return Created manager of entities or null, if it already exists.
     */
    static EntityManager createEntityManager() {
        return (entityManagerFactory != null) ? entityManagerFactory.createEntityManager() : null;
    }

}
