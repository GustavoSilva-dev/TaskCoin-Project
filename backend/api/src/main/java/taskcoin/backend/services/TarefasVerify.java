package taskcoin.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import taskcoin.backend.records.statusTarefa;
import taskcoin.backend.repositorios.TarefasRepository;

import java.time.LocalDate;

@Service
public class TarefasVerify {

    @Autowired
    private TarefasRepository repository;

    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void verificarTarefasExpiradas(){
        var tarefas = repository.findAll();

        tarefas.forEach((tarefa) -> {
            if(tarefa.getStatus() != statusTarefa.CONCLUIDA && tarefa.getStatus() != statusTarefa.ANALISE && tarefa.getStatus() != statusTarefa.PENALIZADA){
                if(LocalDate.now().isAfter(tarefa.getExpiracao())){
                    tarefa.setStatus(statusTarefa.EXPIRADA);
                    repository.save(tarefa);
                }
            }
        });
    }
}
