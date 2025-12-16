package moi.gda.data.backend_gda_data.service.ministry;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import moi.gda.data.backend_gda_data.entity.Ministry;
import moi.gda.data.backend_gda_data.repository.MinistryRepository;

@Service
@RequiredArgsConstructor
public class MinistryService {
  private final MinistryRepository repo;
  public List<Ministry> findAll() { return repo.findAll(); }
}

