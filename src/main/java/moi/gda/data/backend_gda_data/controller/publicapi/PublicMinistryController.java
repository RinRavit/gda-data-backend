

package moi.gda.data.backend_gda_data.controller.publicapi;

import moi.gda.data.backend_gda_data.entity.Ministry;
import moi.gda.data.backend_gda_data.service.ministry.MinistryService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/ministries")
public class PublicMinistryController {

    private final MinistryService service;

    public PublicMinistryController(MinistryService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<Ministry>> list() {
        return ApiResponse.ok(service.publicMinistries());
    }
}
