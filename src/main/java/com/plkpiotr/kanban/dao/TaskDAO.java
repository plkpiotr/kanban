package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Provides "Data Access Object" for "Task" class.
 * @see Task
 */
public class TaskDAO {
    private EntityManager entityManager;

    /**
     * Serves a task through given manager of entities.
     *
     * @param entityManager Manager of entities for task.
     */
    public TaskDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Inserts the task to database.
     *
     * @param task Task object waiting for inserting to database.
     * @return If task was added function return true, otherwise false.
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
        String category = (String) entityManager.createQuery("SELECT t.category from Task t WHERE t.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        int changedTasks;
        switch (category) {
            case "todo":
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                changedTasks = entityManager.createQuery("UPDATE Task t SET t.category = 'doing' WHERE t.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
                if (changedTasks == 1)
                    entityTransaction.commit();
                return;
            case "doing":
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                changedTasks = entityManager.createQuery("UPDATE Task t SET t.category = 'done' WHERE t.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
                if (changedTasks == 1)
                    entityTransaction.commit();
                return;
            case "done":
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                changedTasks = entityManager.createQuery("DELETE FROM Task t WHERE t.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
                if (changedTasks == 1)
                    entityTransaction.commit();
        }
    }
}
