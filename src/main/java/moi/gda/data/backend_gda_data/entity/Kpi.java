
package moi.gda.data.backend_gda_data.entity;

import jakarta.persistence.*;

@Entity
public class Kpi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean approved;
    private boolean isPublic;

    public Long getId() { return id; }
    public String getName() { return name; }
    public boolean isApproved() { return approved; }
    public boolean isPublic() { return isPublic; }

    public void setName(String name) { this.name = name; }
    public void setApproved(boolean approved) { this.approved = approved; }
    public void setPublic(boolean aPublic) { isPublic = aPublic; }
}
