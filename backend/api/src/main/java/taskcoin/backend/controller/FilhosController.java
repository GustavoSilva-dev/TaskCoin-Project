package taskcoin.backend.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import taskcoin.backend.classes.Filhos;
import taskcoin.backend.records.DadosAlterarFilho;
import taskcoin.backend.records.DadosRetornoFilho;
import taskcoin.backend.records.DadosCadastroFilho;
import taskcoin.backend.repositorios.FilhosRepository;
import taskcoin.backend.repositorios.NiveisRepository;
import taskcoin.backend.repositorios.ResponsaveisRepository;
import taskcoin.backend.services.OfensivaService;
import taskcoin.backend.services.TarefasVerify;

import java.time.LocalDate;

@RestController
@RequestMapping("/filhos")
public class FilhosController {

    @Autowired
    private TarefasVerify verify;

    @Autowired
    private OfensivaService ofensivaService;

    @Autowired
    private NiveisRepository repositoryNivel;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ResponsaveisRepository repositoryPai;

    @Autowired
    private FilhosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity CadastrarFilhos(@RequestBody @Valid DadosCadastroFilho dados){
        var nivel = repositoryNivel.getReferenceById(1L);
        var responsavel = repositoryPai.getReferenceById(dados.id_responsavel());
        var filho = new Filhos(dados, encoder, responsavel, nivel);
        repository.save(filho);

        return ResponseEntity.ok().body(new DadosRetornoFilho(filho));
    }

    @GetMapping
    public Page<DadosRetornoFilho> ListarFilhos(@PageableDefault(size=10, sort="nome") Pageable paginacao){
        return repository.findAll(paginacao).map(DadosRetornoFilho::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity EditarFilhos(@RequestBody @Valid DadosAlterarFilho dados){
        var filho = repository.getReferenceById(dados.id_filho());
        filho.alterarFilho(dados);
        repository.save(filho);

        return ResponseEntity.ok(new DadosRetornoFilho(filho));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeletarFilho(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalhe-filho")
    public ResponseEntity DetalharFilho(Authentication authentication){
        var usuario = (Filhos) repository.findByEmail(authentication.getName());
        verify.verificarTarefasExpiradas();
        ofensivaService.verificarOfensiva(usuario.getId(), LocalDate.now());

        return ResponseEntity.ok(new DadosRetornoFilho(usuario));
    }
}
