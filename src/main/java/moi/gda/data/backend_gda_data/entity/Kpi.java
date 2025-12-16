package moi.gda.data.backend_gda_data.entity;

@Entity
@Getter @Setter
public class Kpi extends BaseEntity {
  private String code;
  private String nameEn;
  private String nameKh;
  private boolean isFlow;
}

