package taskcoin.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import taskcoin.backend.classes.Responsaveis;

public interface ResponsaveisRepository extends JpaRepository<Responsaveis, Long> {
     UserDetails findByEmail(String email);
}
