package taskcoin.backend.records;

import taskcoin.backend.classes.Recompensas;

public record DadosRetornoStatusRecompensa(
        Long id_recompensa,
        String nome_recompensa,
        int valor_recompensa,
        statusRecompensa status_recompensa
) {
    public DadosRetornoStatusRecompensa(Recompensas recompensa){
        this(recompensa.getId(), recompensa.getNome(), recompensa.getValor(), recompensa.getStatus());
    }
}
