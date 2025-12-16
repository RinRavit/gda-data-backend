

package moi.gda.data.backend_gda_data.repository;

import moi.gda.data.backend_gda_data.entity.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KpiRepository extends JpaRepository<Kpi, Long> {
    List<Kpi> findByApprovedTrueAndIsPublicTrue();
}
