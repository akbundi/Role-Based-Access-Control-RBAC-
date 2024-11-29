package rbac_ui.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import rbac_ui.models.Role; // Import your custom Role class
import rbac_ui.utils.DBConnection;

public class RoleDAO {
    public List<Role> getAllRoles() throws SQLException {
        String query = "SELECT * FROM Roles";
        List<Role> roles = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("role_name"));
                role.setPermissions(rs.getString("permissions"));
                roles.add(role);
            }
        }
        return roles;
    }
}
