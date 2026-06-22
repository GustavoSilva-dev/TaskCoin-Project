package taskcoin.backend.records;

import taskcoin.backend.classes.Tarefas;

import java.time.LocalDate;

public record DadosRetornoTarefas(
        Long id_tarefa,
        String nome_tarefa,
        String descricao_tarefa,
        statusTarefa status_tarefa,
        int valor_tarefa,
        LocalDate expiracao_tarefa
) {
    public DadosRetornoTarefas(Tarefas tarefa) {
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getValor(), tarefa.getExpiracao());
    }
}
