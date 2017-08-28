package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Project;

import javax.persistence.EntityManager;
import java.util.ArrayList;

/**
 * Provides "Data Access Object" for "Employee" class.
 */
public class EmployeeDAO {
    private EntityManager entityManager;

    /**
     * Creates a employee on the basis of given manager of entities.
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
}
