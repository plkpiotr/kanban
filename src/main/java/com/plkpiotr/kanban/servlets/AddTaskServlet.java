package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.dao.CompanyDAO;
import com.plkpiotr.kanban.dao.ProjectDAO;
import com.plkpiotr.kanban.domain.Employee;
import com.plkpiotr.kanban.domain.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addtask")
public class AddTaskServlet extends HttpServlet {

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
            ProjectDAO projectDAO = (ProjectDAO) request.getAttribute("projectDAO");
            CompanyDAO companyDAO = (CompanyDAO) request.getAttribute("companyDAO");
            Employee employee = (Employee) session.getAttribute("employee");

            Integer idProject = Integer.parseInt(request.getParameter("idProject"));
            Project project = projectDAO.getProjectForEmployee(idProject, employee.getCompany().getId());
            List employees = companyDAO.getEmployees(employee.getCompany().getId());

            request.setAttribute("employees", employees);
            request.setAttribute("project", project);

            request.getRequestDispatcher("/WEB-INF/views/addtask.jsp").forward(request, response);
        }
    }
}
