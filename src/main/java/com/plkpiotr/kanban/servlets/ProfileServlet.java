package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.dao.EmployeeDAO;
import com.plkpiotr.kanban.domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("employeeDAO");
        Employee employee = (Employee) request.getAttribute("employee");

        request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
    }
}
