package moi.gda.data.backend_gda_data.service.auth;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import moi.gda.data.backend_gda_data.repository.UserRepository;
import moi.gda.data.backend_gda_data.security.JwtProvider;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository repo;
  private final JwtProvider jwt;

  public String login(String email) {
    repo.findByEmail(email).orElseThrow();
    return jwt.generateToken(email);
  }
}

