package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Provides "Data Access Object" for "Task" class.
 */
public class TaskDAO {
    private EntityManager entityManager;

    /**
     * Creates a task through given manager of entities.
     *
     * @param entityManager Manager of entities for task.
     */
    public TaskDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Inserts a task to database.
     *
     * @param task Task object waiting for inserting to database.
     */
    public boolean insertTask(Task task) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(task);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
