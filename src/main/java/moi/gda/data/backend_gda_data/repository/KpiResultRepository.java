
package moi.gda.data.backend_gda_data.repository;

import moi.gda.data.backend_gda_data.entity.KpiResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KpiResultRepository extends JpaRepository<KpiResult, Long> {

    List<KpiResult> findByKpiIdAndYearAndApprovedTrueAndIsPublicTrue(
            Long kpiId, Integer year
    );
}
