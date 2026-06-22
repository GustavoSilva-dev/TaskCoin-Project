package taskcoin.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import taskcoin.backend.classes.Filhos;

public interface FilhosRepository extends JpaRepository<Filhos, Long> {
    UserDetails findByEmail(String email);
}
