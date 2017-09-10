package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.dao.EmployeeDAO;
import com.plkpiotr.kanban.domain.Employee;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Serves login form.
 */
@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("employeeDAO");

        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        password = employeeDAO.encodePassword(password);
        try {
            Employee employee = employeeDAO.getEmployeeByNickAndPassword(nick, password);
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);

            response.sendRedirect(request.getContextPath() + "/profile");
        } catch (NoResultException e) {
            request.setAttribute("infoLogin", "Data in login form was invalid.");
            doGet(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }
}
