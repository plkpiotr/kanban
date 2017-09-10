package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.domain.Task;

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
            return false;
        }
    }

    /**
     * Changes category of task selecting by its ID.
     * From "to do" to "doing", from "doing" to "done", but "done" tasks will be removed.
     *
     * @param id Task's ID.
     */
    public void changeCategory(Integer id) {
        Task task = entityManager.find(Task.class, id);
        String category = (String) entityManager.createQuery("SELECT t.category from Task t WHERE t.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        int updatedCount = 0;
        switch (category) {
            case "todo":
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                updatedCount = entityManager.createQuery("UPDATE Task t SET t.category = 'doing' WHERE t.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
                if (updatedCount == 1)
                    entityTransaction.commit();
                return;
            case "doing":
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                updatedCount = entityManager.createQuery("UPDATE Task t SET t.category = 'done' WHERE t.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
                if (updatedCount == 1)
                    entityTransaction.commit();
                return;
            case "done":
                entityManager.createQuery("DELETE FROM Task t WHERE t.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
        }
    }
}
