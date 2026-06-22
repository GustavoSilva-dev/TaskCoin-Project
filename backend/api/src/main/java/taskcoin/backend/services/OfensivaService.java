package taskcoin.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import taskcoin.backend.classes.Filhos;
import taskcoin.backend.repositorios.FilhosRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OfensivaService {

    @Autowired
    private FilhosRepository repository;

    @Transactional
    public void atualizarOfensiva(Long filhoId, LocalDate data) {
        var filho = repository.getReferenceById(filhoId);

        if(filho.getUltima_tarefa().isEqual(data.minusDays(1))){
            filho.setOfensiva(filho.getOfensiva() + 1);
        } else if (filho.getUltima_tarefa().isBefore(data.minusDays(1))) {
            filho.setOfensiva(1);
        }

        if(filho.getOfensiva() > filho.getMaior_ofensiva()){
            filho.setMaior_ofensiva(filho.getOfensiva());
        }

        filho.setUltima_tarefa(data);
    }

    @Transactional
    public void verificarOfensiva(Long filhoId, LocalDate data){
        var filho = repository.getReferenceById(filhoId);

        if (!filho.getUltima_tarefa().isEqual(LocalDate.of(1999, 11, 11)) && filho.getUltima_tarefa().isBefore(data.minusDays(1))) {
            filho.setOfensiva(0);
        }
    }
}
