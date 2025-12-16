package moi.gda.data.backend_gda_data.publicapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import moi.gda.data.backend_gda_data.entity.Ministry;
import moi.gda.data.backend_gda_data.service.ministry.MinistryService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;

@RestController
@RequestMapping("/api/public/ministries")
@RequiredArgsConstructor
public class PublicMinistryController {

  private final MinistryService service;

  @GetMapping
  public ApiResponse<List<Ministry>> list() {
    return ApiResponse.ok(service.findAll());
  }
}

