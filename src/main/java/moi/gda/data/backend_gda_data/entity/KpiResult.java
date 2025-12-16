package moi.gda.data.backend_gda_data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class KpiResult extends BaseEntity {

  @ManyToOne
  private Kpi kpi;

  private Integer year;
  private Integer term;
  private Double value;
  private boolean approved;

  // ✅ EXPLICIT GETTERS / SETTERS
  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }
}
