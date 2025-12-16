package moi.gda.data.backend_gda_data.controller.admin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import moi.gda.data.backend_gda_data.service.kpi.KpiService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;

@RestController
@RequestMapping("/api/admin/kpis")
@RequiredArgsConstructor
public class AdminKpiController {

  private final KpiService service;

  @PutMapping("/results/{id}/approve")
  public ApiResponse<Void> approve(@PathVariable Long id) {
    service.approve(id);
    return ApiResponse.ok(null);
  }
}

