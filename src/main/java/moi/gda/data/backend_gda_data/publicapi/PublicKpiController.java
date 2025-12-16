package moi.gda.data.backend_gda_data.publicapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import moi.gda.data.backend_gda_data.entity.Kpi;
import moi.gda.data.backend_gda_data.entity.KpiResult;
import moi.gda.data.backend_gda_data.service.kpi.KpiService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;

@RestController
@RequestMapping("/api/public/kpis")
@RequiredArgsConstructor
public class PublicKpiController {

  private final KpiService service;

  @GetMapping
  public ApiResponse<List<Kpi>> list() {
    return ApiResponse.ok(service.publicKpis());
  }

  @GetMapping("/{id}/results")
  public ApiResponse<List<KpiResult>> results(
      @PathVariable Long id,
      @RequestParam Integer year) {
    return ApiResponse.ok(service.publicResults(id, year));
  }
}

