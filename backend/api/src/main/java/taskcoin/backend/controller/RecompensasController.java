package taskcoin.backend.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskcoin.backend.classes.Recompensas;
import taskcoin.backend.records.DadosAlterarRecompensa;
import taskcoin.backend.records.DadosCriarRecompensa;
import taskcoin.backend.records.DadosRetornoRecompensa;
import taskcoin.backend.records.DadosRetornoStatusRecompensa;
import taskcoin.backend.repositorios.FilhosRepository;
import taskcoin.backend.repositorios.RecompensasRepository;
import taskcoin.backend.repositorios.ResponsaveisRepository;

@RestController
@RequestMapping("/recompensas")
public class RecompensasController {

    @Autowired
    public RecompensasRepository repository;

    @Autowired
    public FilhosRepository repositoryFilho;

    @Autowired
    public ResponsaveisRepository repositoryResponsavel;

    @PostMapping
    @Transactional
    public ResponseEntity CriarRecompensas(@RequestBody @Valid DadosCriarRecompensa dados){
        var filho = repositoryFilho.getReferenceById(dados.id_filho());
        var responsavel = repositoryResponsavel.getReferenceById(dados.id_responsavel());
        var recompensa = new Recompensas(dados, filho, responsavel);
        repository.save(recompensa);

        return ResponseEntity.ok().body(recompensa);
    }

    @PutMapping
    @Transactional
    public ResponseEntity AlterarRecompensa(@RequestBody @Valid DadosAlterarRecompensa dados){
        var recompensa = repository.getReferenceById(dados.id_recompensa());
        recompensa.alterarRecompensa(dados);

        return ResponseEntity.ok().body(new DadosRetornoStatusRecompensa(recompensa));
    }

    @GetMapping
    public Page<DadosRetornoRecompensa> ListarRecompensas(@PageableDefault(size=10, sort="nome")Pageable paginacao){
        return repository.findAll(paginacao).map(DadosRetornoRecompensa::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeletarRecompensa(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
