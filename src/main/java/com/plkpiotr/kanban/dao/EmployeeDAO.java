package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Employee;
import com.plkpiotr.kanban.api.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;

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
     * Gets all projects in the employee participates
     *
     * @param id ID employee's.
     */
    public ArrayList<Project> getProjects(int id) {
        return new ArrayList<Project>();
    }

    /**
     * Adds a employee to database.
     *
     * @param employee Employee object waiting for adding
     */
    public boolean addEmployee(Employee employee) {
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
     * Encodes password through "Message-Digest algorithm 5".
     *
     * @param password Password posts in a form.
     */
    private String encodePassword(String password) {
        return new String();
    }
}
