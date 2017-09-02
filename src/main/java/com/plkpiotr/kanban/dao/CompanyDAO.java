package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
    public boolean insertEmployee(Company company) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(company);
            entityTransaction.commit();
            return true;
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }
}
