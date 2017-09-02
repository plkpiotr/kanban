package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

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
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * Gets all tasks for a employee.
     *
     * @param idEmployee ID employee's.
     */
    public List<Task> listOfAllTasks(final int idEmployee) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaQuery = builder.createQuery(Task.class);
        Root<Task> task = criteriaQuery.from(Task.class);
        Path<Long> id = task.get("id");
        criteriaQuery.select(task).where(builder.equal(id, idEmployee));
        TypedQuery<Task> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Gets tasks for a employee by category.
     *
     * @param tasks List of all tasks for a employee.
     * @param category One of the category task's: "todo", "doing" or "done".
     */
    public List<Task> listOfTasksByCategory(List<Task> tasks, final String category) {
        tasks.stream()
                .filter(task -> category.equals(task.getCategory()))
                .collect(Collectors.toList());
        return tasks;
    }


}
