
package moi.gda.data.backend_gda_data.service.auth;

// import moi.gda.data.backend_gda_data.controller.auth.dto.*;
import moi.gda.data.backend_gda_data.dto.auth.AuthResponse;
import moi.gda.data.backend_gda_data.dto.auth.LoginRequest;
import moi.gda.data.backend_gda_data.dto.auth.RegisterRequest;
import moi.gda.data.backend_gda_data.entity.User;
import moi.gda.data.backend_gda_data.repository.UserRepository;
import moi.gda.data.backend_gda_data.security.JwtProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public AuthService(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public AuthResponse register(RegisterRequest req) {
        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());

        userRepository.save(user);

        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest req) {
        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
