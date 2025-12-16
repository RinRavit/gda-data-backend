package moi.gda.data.backend_gda_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import moi.gda.data.backend_gda_data.entity.KpiResult;

public interface KpiResultRepository extends JpaRepository<KpiResult, Long> {
    List<KpiResult> findByKpiIdAndYearAndApprovedTrue(Long id, Integer year);
  }
  
