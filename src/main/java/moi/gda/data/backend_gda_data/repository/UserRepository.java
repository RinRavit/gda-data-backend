package moi.gda.data.backend_gda_data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import moi.gda.data.backend_gda_data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
  }
  
