package taskcoin.backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taskcoin.backend.classes.Filhos;
import taskcoin.backend.classes.Responsaveis;
import taskcoin.backend.infra.security.TokenService;
import taskcoin.backend.records.DadosAutenticacao;
import taskcoin.backend.records.DadosRetornoToken;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/filhos")
    public ResponseEntity loginFilho(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Filhos) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosRetornoToken(tokenJWT));
    }

    @PostMapping("/responsaveis")
    public ResponseEntity loginResponsavel(@RequestBody @Valid DadosAutenticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Responsaveis) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosRetornoToken(tokenJWT));
    }
}
