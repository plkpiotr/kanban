package com.plkpiotr.kanban.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("employee") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {

            // EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("employeeDAO");
            // Employee employee = (Employee) request.getAttribute("employee");

            request.getRequestDispatcher("/WEB-INF/views/company.jsp").forward(request, response);
        }
    }
}
