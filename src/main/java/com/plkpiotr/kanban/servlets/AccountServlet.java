package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("initEmployeeDAO");
//        List<Task> allTasks = employeeDAO.getAllTasks(1); // default id
//        request.setAttribute("allTasks", allTasks);
        request.getRequestDispatcher("/WEB-INF/views/account.jsp").forward(request, response);
    }
}
