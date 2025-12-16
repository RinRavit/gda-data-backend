package moi.gda.data.backend_gda_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User extends BaseEntity {
  @Column(unique = true)
  private String email;
  private String password;
}

