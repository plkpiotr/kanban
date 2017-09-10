package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.dao.CompanyDAO;
import com.plkpiotr.kanban.dao.ProjectDAO;
import com.plkpiotr.kanban.domain.Employee;
import com.plkpiotr.kanban.domain.Project;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Serves view of a company, adding and deleting projects carry out in a company.
 */
@WebServlet("/company")
public class CompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        ProjectDAO projectDAO = (ProjectDAO) request.getAttribute("projectDAO");
        Employee employee = (Employee) session.getAttribute("employee");

        try {
            Integer idProject = Integer.parseInt(request.getParameter("idProject"));
            if (idProject == 0) {
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                Project project = new Project();
                project.setName(name);
                project.setDescription(description);
                project.setCompany(employee.getCompany());
                if (projectDAO.insertProject(project)) {
                    response.sendRedirect(request.getContextPath() + "/company");
                } else {
                    request.setAttribute("infoProject", "The project wasn't created.");
                    doGet(request, response);
                }
            } else {
                Project project = projectDAO.getProjectForEmployee(idProject, employee.getCompany().getId());
                if (projectDAO.deleteProject(project))
                    response.sendRedirect(request.getContextPath() + "/company");
                else {
                    request.setAttribute("infoProject", "The project wasn't deleted.");
                    doGet(request, response);
                }
            }
        } catch (NoResultException e) {
            request.setAttribute("infoProject", "The project was deleted before.");
            doGet(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("employee") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setCharacterEncoding("UTF-8");
            Employee employee = (Employee) session.getAttribute("employee");
            CompanyDAO companyDAO = (CompanyDAO) request.getAttribute("companyDAO");

            List employees = companyDAO.getEmployees(employee.getCompany().getId());
            List projects = companyDAO.getProjects(employee.getCompany().getId());

            request.setAttribute("employees", employees);
            request.setAttribute("projects", projects);

            request.getRequestDispatcher("/WEB-INF/views/company.jsp").forward(request, response);
        }
    }
}
