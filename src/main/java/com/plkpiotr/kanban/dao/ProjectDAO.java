package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

//    /**
//     * Gets tasks in a project by category.
//     *
//     * @param category One of the category task's: todo [0], doing [1], done [2].
//     * @param idProject Name of reviewed project
//     */
//    public List<Task> fillListOfTasksByCategory(int category, int idProject) {
//        return new List<Task>();
//    }
//
//    /**
//     * Gets employees in a company.
//     *
//     * @param company Name of company.
//     */
//    public List<String> fillListOfEmployeesInCompany(String company) {
//        return List<String>();
//    }
}
