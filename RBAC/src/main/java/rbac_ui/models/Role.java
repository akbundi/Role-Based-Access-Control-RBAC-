package rbac_ui.models;

public class Role {
    private int id;
    private String roleName;
    private String permissions;

    // Default constructor
    public Role() {}

    // Parameterized constructor
    public Role(int id, String roleName, String permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
