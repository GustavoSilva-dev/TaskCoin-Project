package taskcoin.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import taskcoin.backend.classes.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

}
