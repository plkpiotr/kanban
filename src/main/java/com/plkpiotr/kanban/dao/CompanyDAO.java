package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.domain.Company;
import com.plkpiotr.kanban.domain.Employee;
import com.plkpiotr.kanban.domain.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CompanyDAO {
    private EntityManager entityManager;

    /**
     * Creates a company through given manager of entities.
     *
     * @param entityManager Manager of entities for employee.
     */
    public CompanyDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Inserts a company to database.
     *
     * @param company Company object waiting for inserting to database.
     */
    public void insertCompany(Company company) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(company);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Gets all projects in a company.
     *
     * @param idCompany ID company's.
     */
    public List<Project> getProjects(final int idCompany) {
        return entityManager.createQuery("SELECT p from Project p WHERE p.company.id = :idCompany")
                .setParameter("idCompany", idCompany)
                .getResultList();
    }

    /**
     * Gets all employees in a company.
     *
     * @param idCompany ID company's.
     */
    public List<Employee> getEmployees(final int idCompany) {
        return entityManager.createQuery("SELECT e from Employee e WHERE e.company.id = :idCompany")
                .setParameter("idCompany", idCompany)
                .getResultList();
    }
}
