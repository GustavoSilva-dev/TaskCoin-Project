package taskcoin.backend.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroResponsavel(
        @NotBlank
        String nome_pai,
        @NotBlank
        @Email
        String email_pai,
        @NotBlank
        String senha_pai
) {
}
