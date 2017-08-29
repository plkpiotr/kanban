package com.plkpiotr.kanban.listeners;

import com.plkpiotr.kanban.dao.EmployeeDAO;
import com.plkpiotr.kanban.dao.ProjectDAO;
import com.plkpiotr.kanban.dao.TaskDAO;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


/**
 * Initializes ready for use DAO objects.
 */
@WebListener()
public class InitializationListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        EntityManager entityManager = ConfigurationListener.createEntityManager();
        EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);
        ProjectDAO projectDAO = new ProjectDAO(entityManager);
        TaskDAO taskDAO = new TaskDAO(entityManager);
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        servletRequest.setAttribute("initializedEmployeeDAO", employeeDAO);
        servletRequest.setAttribute("initializedProjectDAO", projectDAO);
        servletRequest.setAttribute("initializedTaskDAO", taskDAO);
    }
}
