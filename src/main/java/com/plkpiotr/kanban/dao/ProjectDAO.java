package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Project;
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
 * Provides "Data Access Object" for "Project" class.
 */
public class ProjectDAO {
    private EntityManager entityManager;

    /**
     * Creates a project through given manager of entities.
     *
     * @param entityManager Manager of entities for project.
     */
    public ProjectDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Inserts a project to database.
     *
     * @param project Project object waiting for inserting to database.
     */
    public boolean insertProject(Project project) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(project);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Gets all tasks in a project.
     *
     * @param idProject ID project's.
     */
    public List<Task> getAllTasks(final int idProject) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaQuery = builder.createQuery(Task.class);
        Root<Task> task = criteriaQuery.from(Task.class);
        Path<Long> id = task.get("id_project");
        criteriaQuery.select(task).where(builder.equal(id, idProject));
        TypedQuery<Task> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Gets tasks for a employee by category.
     *
     * @param tasks List of all tasks for a employee.
     * @param category One of the category task's: "todo", "doing" or "done".
     */
    public List<Task> getTasksByCategory(List<Task> tasks, final String category) {
        tasks.stream()
                .filter(task -> category.equals(task.getCategory()))
                .collect(Collectors.toList());
        return tasks;
    }
}
