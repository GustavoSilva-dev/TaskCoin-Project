package taskcoin.backend.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFilho(
        @NotBlank
        String nome_filho,
        @NotBlank
        @Email
        String email_filho,
        @NotBlank
        String senha_filho,
        @NotNull
        Long id_responsavel
) {
}
