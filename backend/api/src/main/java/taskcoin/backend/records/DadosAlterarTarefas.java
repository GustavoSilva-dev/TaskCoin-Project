package taskcoin.backend.records;

import jakarta.validation.constraints.NotNull;

public record DadosAlterarTarefas(
    @NotNull
    Long id_tarefa,
    statusTarefa status_tarefa
) {
}
