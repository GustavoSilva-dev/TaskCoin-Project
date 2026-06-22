package taskcoin.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import taskcoin.backend.classes.Niveis;

public interface NiveisRepository extends JpaRepository<Niveis, Long> {
}
