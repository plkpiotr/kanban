package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.domain.Company;
import com.plkpiotr.kanban.domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("employee") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setCharacterEncoding("UTF-8");
            Employee employee = (Employee) session.getAttribute("employee");
            Company company = employee.getCompany();

            List employees = company.getListOfEmployees();
            List projects = company.getListOfProjects();

            request.setAttribute("employees", employees);
            request.setAttribute("projects", projects);

            request.getRequestDispatcher("/WEB-INF/views/company.jsp").forward(request, response);
        }
    }
}
