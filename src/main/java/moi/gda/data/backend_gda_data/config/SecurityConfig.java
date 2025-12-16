// package moi.gda.data.backend_gda_data.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import lombok.RequiredArgsConstructor;
// import moi.gda.data.backend_gda_data.security.JwtFilter;

// @Configuration
// @RequiredArgsConstructor
// public class SecurityConfig {

//   private final JwtFilter jwtFilter;

//   @Bean
//   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//     http.csrf(csrf -> csrf.disable())
//       .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//       .authorizeHttpRequests(auth -> auth
//         .requestMatchers("/api/public/**", "/api/auth/**").permitAll()
//         .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//         .anyRequest().authenticated()
//       )
//       .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//     return http.build();
//   }
// }


package moi.gda.data.backend_gda_data.config;

import moi.gda.data.backend_gda_data.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final JwtFilter jwtFilter;

  // ✅ EXPLICIT CONSTRUCTOR (NO LOMBOK)
  public SecurityConfig(JwtFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
      .csrf(csrf -> csrf.disable())
      .sessionManagement(session ->
        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      )
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/public/**", "/api/auth/**").permitAll()
        .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
        .anyRequest().authenticated()
      )
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
