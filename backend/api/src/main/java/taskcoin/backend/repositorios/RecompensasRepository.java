package taskcoin.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import taskcoin.backend.classes.Recompensas;

public interface RecompensasRepository extends JpaRepository<Recompensas, Long> {
}
