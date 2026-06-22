package taskcoin.backend.classes;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "niveis")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "nivel")
public class Niveis {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nivel;

    @Column(name = "titulo_nivel")
    private String titulo_nivel;

    @Column(name = "tarefas_requeridas_nivel")
    private int tarefas_requeridas_nivel;

    @Column(name = "descricao_nivel")
    private String descricao_nivel;

}
