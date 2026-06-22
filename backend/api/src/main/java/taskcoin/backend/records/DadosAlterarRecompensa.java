package taskcoin.backend.records;

import jakarta.validation.constraints.NotNull;

public record DadosAlterarRecompensa(
        @NotNull
        Long id_recompensa,
        statusRecompensa status_recompensa
) {
}
