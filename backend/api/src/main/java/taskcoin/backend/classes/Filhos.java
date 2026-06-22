package taskcoin.backend.classes;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import taskcoin.backend.records.DadosAlterarFilho;
import taskcoin.backend.records.DadosCadastroFilho;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Table(name = "filhos")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Filhos implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_filho")
    private String nome;

    @Column(name = "email_filho")
    private String email;

    @Column(name = "senha_filho")
    private String senha;

    @Column(name = "saldo_pontos")
    private int saldo;

    @Column(name = "ofensiva_atual")
    private int ofensiva = 0;

    @Column(name = "maior_ofensiva")
    private int maior_ofensiva = 0;

    @Column(name = "ultima_tarefa")
    private LocalDate ultima_tarefa;

    @Column(name = "tarefas_concluidas_filho")
    private int tarefas_concluidas;

    @OneToMany(mappedBy = "filho")
    private List<Tarefas> tarefas;

    @OneToMany(mappedBy = "filho")
    private List<Recompensas> recompensas;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsaveis responsavel;

    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private Niveis nivel;

    public Filhos(DadosCadastroFilho dados, PasswordEncoder encoder, Responsaveis responsavel, Niveis nivel){
        this.nome = dados.nome_filho();
        this.email = dados.email_filho();
        this.senha = encoder.encode(dados.senha_filho());
        this.saldo = 0;
        this.tarefas_concluidas = 0;
        this.responsavel = responsavel;
        this.nivel = nivel;
    }

    public void pontuarFilhos(int valor){
        this.saldo += valor;
        this.tarefas_concluidas += 1;
    }

    public void alterarFilho(DadosAlterarFilho dados){
        if(dados.nome_filho() != null){
            this.nome = dados.nome_filho();
        }
        if(dados.email_filho() != null){
            this.email = dados.email_filho();
        }

        this.saldo = dados.saldo_pontos();
    }

    public void despontarFilhos(int valor){
        this.saldo -= valor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
