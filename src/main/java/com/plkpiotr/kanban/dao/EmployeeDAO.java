package com.plkpiotr.kanban.dao;

import com.plkpiotr.kanban.domain.Employee;
import com.plkpiotr.kanban.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
            return false;
        }
    }

    /**
     * Encodes password on the basis of "Message-Digest algorithm 5".
     *
     * @param passwordToHash Password posts in a form.
     */
    public String encodePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i< bytes.length; i++)
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * Gets employee by nick.
     *
     * @param nick Nick employee's.
     */
    public Employee getEmployeeByNick(final String nick) {
        return (Employee) entityManager.createQuery("SELECT e from Employee e WHERE e.nick = :nick")
                .setParameter("nick", nick)
                .getSingleResult();
    }

    /**
     * Gets employee by nick.
     *
     * @param nick Nick employee's.
     * @param password Nick employee's.
     */
    public Employee getEmployeeByNickAndPassword(final String nick, final String password) {
        return (Employee) entityManager.createQuery("SELECT e from Employee e WHERE e.nick = :nick AND e.password = " +
                ":password")
                .setParameter("nick", nick)
                .setParameter("password", password)
                .getSingleResult();
    }

    /**
     * Gets all tasks for a employee.
     *
     * @param idEmployee ID employee's.
     */
    public List getAllTasks(final Integer idEmployee) {
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
     * Gets company by name. WHY?
     *
     * @param name ID company's.
     */
    public List getCompany(final String name) {
        return entityManager.createQuery("SELECT c from Company c WHERE c.name = :name")
                .setParameter("name", name)
                .getResultList();
    }
}
