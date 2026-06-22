package taskcoin.backend.records;

import taskcoin.backend.classes.Niveis;

public record DadosRetornoNivel(
        Long nivel,
        String titulo_nivel,
        int tarefas_requeridas,
        String descricao_nivel
) {
    public DadosRetornoNivel(Niveis dados){
        this(dados.getNivel(), dados.getTitulo_nivel(), dados.getTarefas_requeridas_nivel(), dados.getDescricao_nivel());
    }
}
