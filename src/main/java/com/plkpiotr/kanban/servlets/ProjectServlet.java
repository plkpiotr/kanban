package com.plkpiotr.kanban.servlets;

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

/**
 * Serves view of a project.
 */
@WebServlet("/project")
public class ProjectServlet extends HttpServlet {

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
            Employee employee = (Employee) session.getAttribute("employee");

            Integer idProject = Integer.parseInt(request.getParameter("idProject"));
            Project project = projectDAO.getProjectForEmployee(idProject, employee.getCompany().getId());
            request.setAttribute("project", project);

            List allTasks = projectDAO.getAllTasks(idProject);
            List todoTasks = projectDAO.getTasksByCategory(allTasks, "todo");
            List doingTasks = projectDAO.getTasksByCategory(allTasks, "doing");
            List doneTasks = projectDAO.getTasksByCategory(allTasks, "done");

            request.setAttribute("allTasks", allTasks);
            request.setAttribute("todoTasks", todoTasks);
            request.setAttribute("doingTasks", doingTasks);
            request.setAttribute("doneTasks", doneTasks);

            request.getRequestDispatcher("/WEB-INF/views/project.jsp").forward(request, response);
        }
    }
}
