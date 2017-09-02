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

    /**
     * Gets all projects in a company.
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
}
