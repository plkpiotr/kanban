package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Company;
import com.plkpiotr.kanban.api.Employee;
import com.plkpiotr.kanban.api.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
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
    public boolean insertEmployee(Company company) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(company);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Gets all projects in a company.
     *
     * @param idCompany ID company's.
     */
    public List<Project> getProjects(final int idCompany) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Project> criteriaQuery = builder.createQuery(Project.class);
        Root<Project> project = criteriaQuery.from(Project.class);
        Path<Long> id = project.get("id_company");
        criteriaQuery.select(project).where(builder.equal(id, idCompany));
        TypedQuery<Project> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Gets all employees in a company.
     *
     * @param idCompany ID company's.
     */
    public List<Employee> getEmployees(final int idCompany) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> employee = criteriaQuery.from(Employee.class);
        Path<Long> id = employee.get("id_company");
        criteriaQuery.select(employee).where(builder.equal(id, idCompany));
        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
