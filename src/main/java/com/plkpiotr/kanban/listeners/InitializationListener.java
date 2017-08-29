package com.plkpiotr.kanban.listeners;

import com.plkpiotr.kanban.api.Employee;
import com.plkpiotr.kanban.dao.EmployeeDAO;
import com.plkpiotr.kanban.dao.ProjectDAO;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class InitializationListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        EntityManager entityManager = ConfigurationListener.createEntityManager();
        EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);
        ProjectDAO projectDAO = new ProjectDAO(entityManager);
    }
}
