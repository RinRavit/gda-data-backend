
package moi.gda.data.backend_gda_data.entity;

import jakarta.persistence.*;

@Entity
public class KpiResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Kpi kpi;

    private Integer year;
    private Double value;
    private boolean approved;
    private boolean isPublic;

    public Long getId() { return id; }
    public Kpi getKpi() { return kpi; }
    public Integer getYear() { return year; }
    public Double getValue() { return value; }
    public boolean isApproved() { return approved; }
    public boolean isPublic() { return isPublic; }

    public void setApproved(boolean approved) { this.approved = approved; }
    public void setPublic(boolean aPublic) { isPublic = aPublic; }
}

