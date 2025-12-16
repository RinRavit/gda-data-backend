
package moi.gda.data.backend_gda_data.controller.publicapi;

import moi.gda.data.backend_gda_data.entity.Kpi;
import moi.gda.data.backend_gda_data.entity.KpiResult;
import moi.gda.data.backend_gda_data.service.kpi.KpiService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/public/kpi")
public class PublicKpiController {

    private final KpiService service;

    public PublicKpiController(KpiService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<Kpi>> kpis() {
        return ApiResponse.ok(service.publicKpis());
    }

    @GetMapping("/{id}/results")
    public ApiResponse<List<KpiResult>> results(
            @PathVariable Long id,
            @RequestParam Integer year
    ) {
        return ApiResponse.ok(service.publicResults(id, year));
    }
}
