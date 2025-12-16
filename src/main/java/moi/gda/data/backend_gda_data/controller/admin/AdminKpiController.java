// // // // package moi.gda.data.backend_gda_data.controller.admin;

// // // // import org.springframework.web.bind.annotation.PathVariable;
// // // // import org.springframework.web.bind.annotation.PutMapping;
// // // // import org.springframework.web.bind.annotation.RequestMapping;
// // // // import org.springframework.web.bind.annotation.RestController;

// // // // import lombok.RequiredArgsConstructor;
// // // // import moi.gda.data.backend_gda_data.service.kpi.KpiService;
// // // // import moi.gda.data.backend_gda_data.utils.ApiResponse;

// // // // @RestController
// // // // @RequestMapping("/api/admin/kpis")
// // // // @RequiredArgsConstructor
// // // // public class AdminKpiController {

// // // //   private final KpiService service;

// // // //   @PutMapping("/results/{id}/approve")
// // // //   public ApiResponse<Void> approve(@PathVariable Long id) {
// // // //     service.approve(id);
// // // //     return ApiResponse.ok(null);
// // // //   }
// // // // }


// // // package moi.gda.data.backend_gda_data.controller.admin;

// // // import moi.gda.data.backend_gda_data.service.kpi.KpiService;
// // // import moi.gda.data.backend_gda_data.utils.ApiResponse;
// // // import org.springframework.web.bind.annotation.*;

// // // @RestController
// // // @RequestMapping("/api/admin/kpi")
// // // public class AdminKpiController {

// // //   private final KpiService service;

// // //   // ✅ REQUIRED constructor
// // //   public AdminKpiController(KpiService service) {
// // //     this.service = service;
// // //   }

// // //   @PutMapping("/approve/{id}")
// // //   public ApiResponse<?> approve(@PathVariable Long id) {
// // //     return ApiResponse.ok(service.approveResult(id));
// // //   }
// // // }


// // package moi.gda.data.backend_gda_data.controller.admin;

// // import lombok.RequiredArgsConstructor;
// // import org.springframework.web.bind.annotation.*;
// // import moi.gda.data.backend_gda_data.service.kpi.KpiService;
// // import moi.gda.data.backend_gda_data.utils.ApiResponse;

// // @RestController
// // @RequestMapping("/api/admin/kpi")
// // @RequiredArgsConstructor
// // public class AdminKpiController {

// //   private final KpiService service;

// //   @PutMapping("/approve/{id}")
// //   public ApiResponse<?> approve(@PathVariable Long id) {
// //     return ApiResponse.ok(service.approveResult(id));
// //   }
// // }

// // package moi.gda.data.backend_gda_data.controller.admin;

// // import lombok.RequiredArgsConstructor;
// // import org.springframework.web.bind.annotation.*;
// // import moi.gda.data.backend_gda_data.service.kpi.KpiService;
// // import moi.gda.data.backend_gda_data.utils.ApiResponse;
// // import moi.gda.data.backend_gda_data.entity.KpiResult;

// // @RestController
// // @RequestMapping("/api/admin/kpi")
// // @RequiredArgsConstructor
// // public class AdminKpiController {

// //     private final KpiService service;

// //     @PutMapping("/approve/{id}")
// //     public ApiResponse<KpiResult> approve(@PathVariable Long id) {
// //         return ApiResponse.ok(service.approveResult(id));
// //     }
// // }

// package moi.gda.data.backend_gda_data.controller.admin;

// import moi.gda.data.backend_gda_data.entity.KpiResult;
// import moi.gda.data.backend_gda_data.service.kpi.KpiService;
// import moi.gda.data.backend_gda_data.utils.ApiResponse;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/admin/kpi")
// public class AdminKpiController {

//     private final KpiService service;

//     // ✅ EXPLICIT CONSTRUCTOR (NO LOMBOK)
//     public AdminKpiController(KpiService service) {
//         this.service = service;
//     }

//     @PutMapping("/approve/{id}")
//     public ApiResponse<KpiResult> approve(@PathVariable Long id) {
//         return ApiResponse.ok(service.approveResult(id));
//     }
// }




package moi.gda.data.backend_gda_data.controller.admin;

import moi.gda.data.backend_gda_data.entity.Kpi;
import moi.gda.data.backend_gda_data.service.kpi.KpiService;
import moi.gda.data.backend_gda_data.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/kpi")
public class AdminKpiController {

    private final KpiService service;

    public AdminKpiController(KpiService service) {
        this.service = service;
    }

    @PutMapping("/{id}/approve")
    public ApiResponse<Kpi> approve(@PathVariable Long id) {
        return ApiResponse.ok(service.approve(id));
    }

    @PutMapping("/{id}/public")
    public ApiResponse<Kpi> setPublic(
            @PathVariable Long id,
            @RequestParam boolean value
    ) {
        return ApiResponse.ok(service.setPublic(id, value));
    }
}
