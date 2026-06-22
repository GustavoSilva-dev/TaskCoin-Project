package taskcoin.backend.classes;

import jakarta.persistence.*;
import lombok.*;
import taskcoin.backend.records.DadosAlterarRecompensa;
import taskcoin.backend.records.DadosCriarRecompensa;
import taskcoin.backend.records.statusRecompensa;

@Table(name = "recompensas")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Recompensas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_recompensa")
    private String nome;

    @Column(name = "valor_recompensa")
    private int valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_recompensa")
    private statusRecompensa status;

    @ManyToOne
    @JoinColumn(name = "id_filho")
    private Filhos filho;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsaveis responsavel;

    public Recompensas(DadosCriarRecompensa dados, Filhos filho, Responsaveis responsavel){
        this.nome = dados.nome_recompensa();
        this.valor = dados.valor_recompensa();
        this.status = statusRecompensa.NAO_ADQUIRIDA;
        this.filho = filho;
        this.responsavel = responsavel;
    }

    public void alterarRecompensa(DadosAlterarRecompensa dados){
        if(dados.status_recompensa() != null){
            this.status = dados.status_recompensa();

            if(this.status == statusRecompensa.ADQUIRIDA){
                filho.despontarFilhos(this.valor);
            }
        }
    }
}
