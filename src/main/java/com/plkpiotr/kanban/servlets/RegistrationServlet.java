package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.domain.Company;
import com.plkpiotr.kanban.domain.Employee;
import com.plkpiotr.kanban.dao.CompanyDAO;
import com.plkpiotr.kanban.dao.EmployeeDAO;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Serves registration form.
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
        String companyName = request.getParameter("company");
        EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("employeeDAO");

        // TODO: Data validation in JS/Query

        try {
            employeeDAO.getEmployeeByNick(nick);
            request.setAttribute("infoNick", "Nick: " + nick + " already exist.");
            doGet(request, response);
        } catch (NoResultException e) {
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setNick(nick);
            employee.setPassword(password);
            employee.setAvatar(avatar);
            if (employeeDAO.getCompany(companyName) == null) {
                CompanyDAO companyDAO = (CompanyDAO) request.getAttribute("companyDAO");
                Company company = new Company();
                company.setName(companyName);
                companyDAO.insertCompany(company);
            }
            employee.setCompany(employeeDAO.getCompany(companyName));
            if (employeeDAO.insertEmployee(employee)) {
                request.setAttribute("infoRegistration", "Congratulations! You have just joined in the Kanban Community.");
                doGet(request, response);
            } else {
                request.setAttribute("infoRegistration", "Registration failed.");
                // doGet(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }
}
