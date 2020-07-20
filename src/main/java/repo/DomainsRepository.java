package repo;

import model.Domains;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainsRepository extends JpaRepository<Domains, Long> {

}