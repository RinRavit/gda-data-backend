package moi.gda.data.backend_gda_data.security;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

  private final JwtProvider jwt;

  @Override
  protected void doFilterInternal(HttpServletRequest req,
                                  HttpServletResponse res,
                                  FilterChain chain)
      throws IOException, ServletException {

    String h = req.getHeader("Authorization");
    if (h != null && h.startsWith("Bearer ")) {
      String email = jwt.getEmail(h.substring(7));
      SecurityContextHolder.getContext().setAuthentication(
        new UsernamePasswordAuthenticationToken(email, null, List.of())
      );
    }
    chain.doFilter(req, res);
  }
}
