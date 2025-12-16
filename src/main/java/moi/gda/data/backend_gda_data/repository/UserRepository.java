

package moi.gda.data.backend_gda_data.repository;

import moi.gda.data.backend_gda_data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
