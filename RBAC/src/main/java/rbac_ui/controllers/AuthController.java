package rbac_ui.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rbac_ui.dao.UserDAO;
import rbac_ui.utils.HashingUtils;
import rbac_ui.utils.JWTUtils;

@SuppressWarnings("serial")
@WebServlet("/login")
public class AuthController extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            rbac_ui.models.User user = userDAO.findByUsername(username);
            if (user!= null && HashingUtils.verifyPassword(password, user.getPassword())) {
                String token = JWTUtils.generateToken(user.getUsername(), user.getId());
                resp.setHeader("Authorization", "Bearer " + token);
                resp.sendRedirect("dashboard.jsp");
            } else {
                resp.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}