

package moi.gda.data.backend_gda_data.entity;

import jakarta.persistence.*;

@Entity
public class Ministry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean isPublic;

    public Long getId() { return id; }
    public String getName() { return name; }
    public boolean isPublic() { return isPublic; }

    public void setName(String name) { this.name = name; }
    public void setPublic(boolean aPublic) { isPublic = aPublic; }
}
