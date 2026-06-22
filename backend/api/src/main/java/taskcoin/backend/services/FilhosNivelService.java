package taskcoin.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskcoin.backend.repositorios.FilhosRepository;
import taskcoin.backend.repositorios.NiveisRepository;

@Service
public class FilhosNivelService {

    @Autowired
    private FilhosRepository repository;

    @Autowired
    private NiveisRepository repositoryNiveis;

    @Transactional
    public void verificarNivel(Long id, int valor){
        var filho = repository.getReferenceById(id);
        if(filho.getNivel().getNivel() < 10) {
            if(valor > filho.getNivel().getTarefas_requeridas_nivel()) {
                var novoNivel = repositoryNiveis.getReferenceById(filho.getNivel().getNivel() + 1);
                filho.setNivel(novoNivel);
            }
        }
    }
}
