package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Serves home page.
 */
@WebServlet("/Servlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "Piotr";
        String surname = "Pałka";
        String nick = "plkpiotr";
        String password = "admin";
        String sex = "man";
        String company = "Constructor";
        String avatar = "01.png";
        EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("Employees");
    }
}
