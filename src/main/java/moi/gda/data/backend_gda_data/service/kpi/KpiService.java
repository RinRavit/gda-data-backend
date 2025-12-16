package moi.gda.data.backend_gda_data.service.kpi;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import moi.gda.data.backend_gda_data.entity.Kpi;
import moi.gda.data.backend_gda_data.entity.KpiResult;
import moi.gda.data.backend_gda_data.repository.KpiRepository;
import moi.gda.data.backend_gda_data.repository.KpiResultRepository;

@Service
@RequiredArgsConstructor
public class KpiService {

  private final KpiRepository kpiRepo;
  private final KpiResultRepository resultRepo;

  public List<Kpi> publicKpis() {
    return kpiRepo.findAll();
  }

  public List<KpiResult> publicResults(Long id, Integer year) {
    return resultRepo.findByKpiIdAndYearAndApprovedTrue(id, year);
  }

  public void approve(Long id) {
    KpiResult r = resultRepo.findById(id).orElseThrow();
    r.setApproved(true);
    resultRepo.save(r);
  }
}

