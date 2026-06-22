package taskcoin.backend.records;

import taskcoin.backend.classes.Tarefas;

public record DadosRetornoStatusTarefa(
        Long id,
        String nome,
        statusTarefa status,
        int valor
) {
    public DadosRetornoStatusTarefa(Tarefas tarefa){
        this(tarefa.getId(), tarefa.getNome(), tarefa.getStatus(), tarefa.getValor());
    }
}
