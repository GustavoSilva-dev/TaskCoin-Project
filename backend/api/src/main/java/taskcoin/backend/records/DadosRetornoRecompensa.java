package taskcoin.backend.records;

import taskcoin.backend.classes.Recompensas;

public record DadosRetornoRecompensa(
    Long id_recompensa,
    String nome_recompensa,
    int valor_recompensa,
    statusRecompensa status_recompensa
) {
    public DadosRetornoRecompensa(Recompensas recompensa){
        this(recompensa.getId(), recompensa.getNome(), recompensa.getValor(), recompensa.getStatus());
    }
}
