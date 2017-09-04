package com.plkpiotr.kanban.listeners;

import com.plkpiotr.kanban.dao.CompanyDAO;
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
        CompanyDAO companyDAO = new CompanyDAO(entityManager);
        EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);
        ProjectDAO projectDAO = new ProjectDAO(entityManager);
        TaskDAO taskDAO = new TaskDAO(entityManager);
        ServletRequest request = servletRequestEvent.getServletRequest();
        request.setAttribute("companyDAO", companyDAO);
        request.setAttribute("employeeDAO", employeeDAO);
        request.setAttribute("projectDAO", projectDAO);
        request.setAttribute("taskDAO", taskDAO);
    }
}
