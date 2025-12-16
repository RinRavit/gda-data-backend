

package moi.gda.data.backend_gda_data.service.ministry;

import moi.gda.data.backend_gda_data.entity.Ministry;
import moi.gda.data.backend_gda_data.repository.MinistryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MinistryService {

    private final MinistryRepository repo;

    public MinistryService(MinistryRepository repo) {
        this.repo = repo;
    }

    // ✅ METHOD CONTROLLER EXPECTS
    public List<Ministry> findAll() {
        return repo.findAll();
    }

    // PUBLIC (guest)
    public List<Ministry> publicMinistries() {
        return repo.findByIsPublicTrue();
    }
}
