
package moi.gda.data.backend_gda_data.service.kpi;

import moi.gda.data.backend_gda_data.entity.Kpi;
import moi.gda.data.backend_gda_data.entity.KpiResult;
import moi.gda.data.backend_gda_data.repository.KpiRepository;
import moi.gda.data.backend_gda_data.repository.KpiResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KpiService {

    private final KpiRepository kpiRepo;
    private final KpiResultRepository resultRepo;

    public KpiService(KpiRepository kpiRepo, KpiResultRepository resultRepo) {
        this.kpiRepo = kpiRepo;
        this.resultRepo = resultRepo;
    }

    // PUBLIC
    public List<Kpi> publicKpis() {
        return kpiRepo.findByApprovedTrueAndIsPublicTrue();
    }

    public List<KpiResult> publicResults(Long kpiId, Integer year) {
        return resultRepo
            .findByKpiIdAndYearAndApprovedTrueAndIsPublicTrue(kpiId, year);
    }

    // ADMIN
    public Kpi approve(Long id) {
        Kpi kpi = kpiRepo.findById(id).orElseThrow();
        kpi.setApproved(true);
        return kpiRepo.save(kpi);
    }

    public Kpi setPublic(Long id, boolean value) {
        Kpi kpi = kpiRepo.findById(id).orElseThrow();
        kpi.setPublic(value);
        return kpiRepo.save(kpi);
    }
}
