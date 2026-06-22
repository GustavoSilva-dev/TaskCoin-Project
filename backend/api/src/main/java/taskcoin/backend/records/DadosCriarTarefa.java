package taskcoin.backend.records;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCriarTarefa(
        @NotBlank
        String nome_tarefa,
        @NotNull
        int valor_tarefa,
        @NotBlank
        String descricao_tarefa,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate expiracao_tarefa,
        @NotNull
        Long id_filho,
        @NotNull
        Long id_responsavel
) {
}
