package rbac_ui.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rbac_ui.dao.RoleDAO;

@WebServlet("/roles")
public class RoleController extends HttpServlet {
    private RoleDAO roleDAO = new RoleDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("roles", roleDAO.getAllRoles());
            req.getRequestDispatcher("roles.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}