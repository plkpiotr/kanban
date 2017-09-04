package com.plkpiotr.kanban.filters;

import com.plkpiotr.kanban.api.Employee;
import com.plkpiotr.kanban.dao.EmployeeDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*") // access
public class LoggedOnFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String nick = request.getRemoteUser();
        if (nick != null) {
            Employee employee = (Employee) request.getSession().getAttribute("employee");
            if (employee == null) {
                EmployeeDAO employeeDAO = (EmployeeDAO) request.getAttribute("employeeDAO");
                employee = employeeDAO.getEmployee(nick);
                request.getSession().setAttribute("employee", employee);
            }
        }
         chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
