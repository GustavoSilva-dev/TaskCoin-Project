package taskcoin.backend.records;

import taskcoin.backend.classes.Responsaveis;

public record DadosRetornoResponsavelAssociado(
        String nome,
        String email
) {
    public DadosRetornoResponsavelAssociado(Responsaveis responsavel){
        this(responsavel.getNome(), responsavel.getEmail());
    }
}
