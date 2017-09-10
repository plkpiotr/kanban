package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.domain.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Provides "Data Access Object" for "Company" class.
 * @see Company
 */
public class CompanyDAO {
    private EntityManager entityManager;

    /**
     * Serves a company through given manager of entities.
     *
     * @param entityManager Manager of entities for employee.
     */
    public CompanyDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Inserts the company to database.
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
        }
    }

    /**
     * Gets all projects in the company.
     *
     * @param idCompany ID company's.
     * @return All projects in the company as list.
     */
    public List getProjects(final int idCompany) {
        return entityManager.createQuery("SELECT p from Project p WHERE p.company.id = :idCompany")
                .setParameter("idCompany", idCompany)
                .getResultList();
    }

    /**
     * Gets all employees in the company.
     *
     * @param idCompany ID company's.
     * @return All employees in the company as list.
     */
    public List getEmployees(final int idCompany) {
        return entityManager.createQuery("SELECT e from Employee e WHERE e.company.id = :idCompany")
                .setParameter("idCompany", idCompany)
                .getResultList();
    }
}
