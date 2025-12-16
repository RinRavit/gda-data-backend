package moi.gda.data.backend_gda_data.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import moi.gda.data.backend_gda_data.service.auth.AuthService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService service;

  @PostMapping("/login")
  public ApiResponse<String> login(@RequestParam String email) {
    return ApiResponse.ok(service.login(email));
  }
}
