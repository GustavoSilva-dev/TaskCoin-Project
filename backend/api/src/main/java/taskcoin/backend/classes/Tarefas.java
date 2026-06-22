package taskcoin.backend.classes;

import jakarta.persistence.*;
import lombok.*;
import taskcoin.backend.records.DadosAlterarTarefas;
import taskcoin.backend.records.DadosCriarTarefa;
import taskcoin.backend.records.statusTarefa;

import java.time.LocalDate;

@Table(name = "tarefas")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Tarefas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_tarefa")
    private String nome;

    @Column(name = "valor_tarefa")
    private int valor;

    @Column(name = "descricao_tarefa")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_tarefa")
    private statusTarefa status;

    @Column(name = "expiracao_tarefa")
    private LocalDate expiracao;

    @ManyToOne
    @JoinColumn(name = "id_filho")
    private Filhos filho;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsaveis responsavel;

    public Tarefas(DadosCriarTarefa dados, Filhos filho, Responsaveis responsavel){
        this.nome = dados.nome_tarefa();
        this.valor = dados.valor_tarefa();
        this.descricao = dados.descricao_tarefa();
        this.expiracao = dados.expiracao_tarefa();
        this.status = statusTarefa.A_FAZER;
        this.filho = filho;
        this.responsavel = responsavel;
    }

    public void atualizarTarefas(DadosAlterarTarefas dados){
        if(dados.status_tarefa() != null){
            this.status = dados.status_tarefa();

            if(this.status == statusTarefa.CONCLUIDA){
                filho.pontuarFilhos(this.valor);
            }
            if(this.status == statusTarefa.PENALIZADA){
                filho.despontarFilhos(this.valor);
            }
        }
    }
}
