package moi.gda.data.backend_gda_data.dto.auth;

public class RegisterRequest {
    private String email;
    private String password;
    private String role;

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
