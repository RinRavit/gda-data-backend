package gda.data.backend.gda_data_backend.service.kpi;

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

