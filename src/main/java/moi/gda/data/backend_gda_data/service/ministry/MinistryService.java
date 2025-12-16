package gda.data.backend.gda_data_backend.service.ministry;

@Service
@RequiredArgsConstructor
public class MinistryService {
  private final MinistryRepository repo;
  public List<Ministry> findAll() { return repo.findAll(); }
}

