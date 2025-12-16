package moi.gda.data.backend_gda_data.entity;

@Entity
@Getter @Setter
public class KpiResult extends BaseEntity {
  @ManyToOne
  private Kpi kpi;
  private Integer year;
  private Integer term;
  private Double value;
  private boolean approved;
}

