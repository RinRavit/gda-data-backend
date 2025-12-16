package moi.gda.data.backend_gda_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import moi.gda.data.backend_gda_data.entity.Kpi;

public interface KpiRepository extends JpaRepository<Kpi, Long> {}