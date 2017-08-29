package com.plkpiotr.kanban.dao;

import javax.persistence.EntityManager;

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
}
