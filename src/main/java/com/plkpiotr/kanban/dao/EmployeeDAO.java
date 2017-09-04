package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.api.Company;
import com.plkpiotr.kanban.api.Employee;
import com.plkpiotr.kanban.api.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

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
        // employee.setPassword(this.encodePassword(employee.getPassword()));
        try {
            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Encodes password through "Message-Digest algorithm 5".
     *
     * @param password Password posts in a form.
     */
    private String encodePassword(String password) {
        MessageDigest messageDigest = null;
        try {
            MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        messageDigest.update(password.getBytes());
        BigInteger hashCode = new BigInteger(1, messageDigest.digest());
        String finished = hashCode.toString(16);
        if (finished.length() == 31)
            finished = "0" + finished;
        return finished;
    }

    /**
     * Gets employee by nick.
     *
     * @param nick Nick employee's.
     */
    public Employee getEmployee(final String nick) {
        return (Employee) entityManager.createQuery("SELECT e from Employee e WHERE e.nick = :nick")
                .setParameter("nick", nick)
                .getSingleResult();
    }

    /**
     * Gets all tasks for a employee.
     *
     * @param idEmployee ID employee's.
     */
    public List<Task> getAllTasks(final int idEmployee) {
        return entityManager.createQuery("SELECT t from Task t WHERE t.employee.id = :idEmployee")
                .setParameter("idEmployee", idEmployee)
                .getResultList();
    }

    /**
     * Gets tasks for a employee by category.
     *
     * @param tasks List of all tasks for a employee.
     * @param category One of the category task's: "todo", "doing" or "done".
     */
    public List<Task> getTasksByCategory(List<Task> tasks, final String category) {
        return tasks.stream()
                .filter(task -> category.equals(task.getCategory()))
                .collect(Collectors.toList());
    }

    /**
     * Gets company by name.
     *
     * @param name ID company's.
     */
    public Company getCompany(final String name) {
        return (Company) entityManager.createQuery("SELECT c from Company c WHERE c.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }
}
