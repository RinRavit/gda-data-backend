package gda.data.backend.gda_data_backend.service.auth;

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

