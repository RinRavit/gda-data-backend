
package moi.gda.data.backend_gda_data.controller.auth;

import moi.gda.data.backend_gda_data.dto.auth.*;
import moi.gda.data.backend_gda_data.dto.auth.AuthResponse;
import moi.gda.data.backend_gda_data.dto.auth.LoginRequest;
import moi.gda.data.backend_gda_data.dto.auth.RegisterRequest;
import moi.gda.data.backend_gda_data.service.auth.AuthService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ApiResponse.ok(service.register(request));
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody LoginRequest request) {
        return ApiResponse.ok(service.login(request));
    }
}
