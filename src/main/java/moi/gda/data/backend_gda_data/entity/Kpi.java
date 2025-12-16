package moi.gda.data.backend_gda_data.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Kpi extends BaseEntity {
  private String code;
  private String nameEn;
  private String nameKh;
  private boolean isFlow;
}

