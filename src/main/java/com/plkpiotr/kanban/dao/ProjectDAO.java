package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.domain.Project;
import com.plkpiotr.kanban.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides "Data Access Object" for "Project" class.
 * @see Project
 */
public class ProjectDAO {
    private EntityManager entityManager;

    /**
     * Serves a project through given manager of entities.
     *
     * @param entityManager Manager of entities for project.
     */
    public ProjectDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Inserts the project to database.
     *
     * @param project Project object waiting for inserting to database.
     * @return If project was added function return true, otherwise false.
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
            return false;
        }
    }

    /**
     * Deletes the project from database
     *
     * @param project Project object waiting for deleting from database.
     * @return If employee was deleted true, otherwise false.
     */
    public boolean deleteProject(Project project) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(project);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Gets a project by ID project's and ID of company from session.
     * Employee has access to all projects in company.
     *
     * @param idProject Project's ID.
     * @param idCompany ID of the company from session.
     * @return All projects in the company as list.
     */
    public Project getProjectForEmployee(final Integer idProject, final Integer idCompany) {
        return (Project) entityManager.createQuery("SELECT p from Project p WHERE p.id = :idProject AND p.company.id" +
                " = :idCompany")
                .setParameter("idProject", idProject)
                .setParameter("idCompany", idCompany)
                .getSingleResult();
    }

    /**
     * Gets all tasks in the project.
     *
     * @param idProject ID project's.
     * @return All tasks in the project as list.
     */
    public List getAllTasks(final Integer idProject) {
        return entityManager.createQuery("SELECT t from Task t WHERE t.project.id = :idProject")
                .setParameter("idProject", idProject)
                .getResultList();
    }

    /**
     * Gets tasks for the employee by category.
     *
     * @param tasks List of all tasks for a employee.
     * @param category One of the category task's: "todo", "doing" or "done".
     * @return One kind of tasks for one employee as list.
     */
    public List<Task> getTasksByCategory(List<Task> tasks, final String category) {
        return tasks.stream()
                .filter(task -> category.equals(task.getCategory()))
                .collect(Collectors.toList());
    }
}
