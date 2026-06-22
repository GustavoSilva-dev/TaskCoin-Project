package taskcoin.backend.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskcoin.backend.classes.Tarefas;
import taskcoin.backend.records.*;
import taskcoin.backend.repositorios.FilhosRepository;
import taskcoin.backend.repositorios.ResponsaveisRepository;
import taskcoin.backend.repositorios.TarefasRepository;
import taskcoin.backend.services.FilhosNivelService;
import taskcoin.backend.services.OfensivaService;

import java.time.LocalDate;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private OfensivaService ofensivaService;

    @Autowired
    private FilhosNivelService nivelService;

    @Autowired
    private TarefasRepository repository;

    @Autowired
    private FilhosRepository repositoryFilhos;

    @Autowired
    private ResponsaveisRepository repositoryResponsaveis;

    @PostMapping
    @Transactional
    public ResponseEntity CriarTarefas(@RequestBody @Valid DadosCriarTarefa dados){
        var filho = repositoryFilhos.getReferenceById(dados.id_filho());
        var responsavel = repositoryResponsaveis.getReferenceById(dados.id_responsavel());
        var tarefa = new Tarefas(dados, filho, responsavel);
        repository.save(tarefa);

        return ResponseEntity.ok().body(tarefa);
    }

    @PutMapping
    @Transactional
    public ResponseEntity AlterarTarefas(@RequestBody @Valid DadosAlterarTarefas dados){
        var tarefa = repository.getReferenceById(dados.id_tarefa());
        tarefa.atualizarTarefas(dados);

        if(tarefa.getStatus() == statusTarefa.CONCLUIDA){
            var filhoId = tarefa.getFilho().getId();
            var filhoTarefas = tarefa.getFilho().getTarefas_concluidas();
            nivelService.verificarNivel(filhoId, filhoTarefas);
            ofensivaService.atualizarOfensiva(filhoId, LocalDate.now());
        }

        return ResponseEntity.ok().body(new DadosRetornoStatusTarefa(tarefa));
    }

    @GetMapping
    public Page<DadosRetornoTarefas> ListarTarefas(@PageableDefault(size=10, sort="nome") Pageable paginacao){
        return repository.findAll(paginacao).map(DadosRetornoTarefas::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeletarTarefa(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
