package taskcoin.backend.records;

import jakarta.validation.constraints.NotNull;

public record DadosAlterarFilho(
        @NotNull
        Long id_filho,
        String nome_filho,
        String email_filho,
        int saldo_pontos
) {
}
