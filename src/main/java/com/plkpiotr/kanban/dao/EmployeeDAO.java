package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Employee;
import com.plkpiotr.kanban.api.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Provides "Data Access Object" for "Employee" class.
 */
public class EmployeeDAO {
    private EntityManager entityManager;

    /**
     * Creates a employee through given manager of entities.
     *
     * @param entityManager Manager of entities for employee.
     */
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Inserts a employee to database.
     *
     * @param employee Employee object waiting for inserting to database.
     */
    public boolean insertEmployee(Employee employee) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
            return true;
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * Gets all projects in the employee participates.
     *
     * @param idEmployee ID employee's in the table with tasks.
     */
    public List<Project> getListOfProjects(int idEmployee) {
        List listOfProjects = this.entityManager.createNativeQuery("SELECT projects.name, projects.description,  " +
                "projects.color FROM projects, tasks WHERE tasks.\"idEmployee\" = :idEmployee AND projects.id = " +
                "tasks.\"idProject\"")
                .setParameter("idEmployee",idEmployee)
                .getResultList();
        return listOfProjects;
    }

    /**
     * Encodes password through "Message-Digest algorithm 5".
     *
     * @param password Password posts in a form.
     */
    private String encodePassword(String password) {
        return new String();
    }
}
