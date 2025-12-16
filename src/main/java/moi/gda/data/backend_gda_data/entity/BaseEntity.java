package moi.gda.data.backend_gda_data.entity;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}

