package com.plkpiotr.kanban.servlets;

import com.plkpiotr.kanban.api.Task;
import com.plkpiotr.kanban.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("initEmployeeDAO");
        List<Task> allTasks = employeeDAO.getAllTasks(1); // to modify!

        List<Task> todoTasks = employeeDAO.getTasksByCategory(allTasks, "todo");
        request.setAttribute("todoTasks", todoTasks);

        List<Task> doingTasks = employeeDAO.getTasksByCategory(allTasks, "doing");
        request.setAttribute("doingTasks", doingTasks);

        List<Task> doneTasks = employeeDAO.getTasksByCategory(allTasks, "done");
        request.setAttribute("doneTasks", doneTasks);

        //request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
    }
}
