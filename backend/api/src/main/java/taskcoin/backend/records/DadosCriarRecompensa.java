package taskcoin.backend.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriarRecompensa(
        @NotBlank
        String nome_recompensa,
        @NotNull
        int valor_recompensa,
        @NotNull
        Long id_filho,
        @NotNull
        Long id_responsavel
) {
}
