package taskcoin.backend.records;

import taskcoin.backend.classes.Filhos;

import java.time.LocalDate;
import java.util.List;

public record DadosRetornoFilho(
        Long id,
        String nome,
        String email,
        int saldo,
        int tarefas_concluidas,
        int ofensiva_atual,
        int maior_ofensiva,
        LocalDate ultima_tarefa,
        DadosRetornoNivel nivel,
        List<DadosRetornoTarefas> tarefas,
        List<DadosRetornoRecompensa> recompensas,
        DadosRetornoResponsavelAssociado responsavel
) {
    public DadosRetornoFilho(Filhos dados){
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getSaldo(), dados.getTarefas_concluidas(), dados.getOfensiva(), dados.getMaior_ofensiva(), dados.getUltima_tarefa(), new DadosRetornoNivel(dados.getNivel()),
                dados.getTarefas() == null ? List.of() : dados.getTarefas().stream().map(DadosRetornoTarefas::new).toList(), dados.getRecompensas() == null ? List.of() : dados.getRecompensas().stream().map(DadosRetornoRecompensa::new).toList(), new DadosRetornoResponsavelAssociado(dados.getResponsavel()));
    }
}
