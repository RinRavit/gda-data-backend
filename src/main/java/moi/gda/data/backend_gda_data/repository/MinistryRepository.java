

package moi.gda.data.backend_gda_data.repository;

import moi.gda.data.backend_gda_data.entity.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MinistryRepository extends JpaRepository<Ministry, Long> {
    List<Ministry> findByIsPublicTrue();
}
