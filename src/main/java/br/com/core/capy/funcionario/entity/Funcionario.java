package br.com.core.capy.funcionario.entity;

import br.com.core.capy.funcionario.enumx.Cargo;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "FUNCIONARIO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_FUNC", sequenceName = "SEQ_FUNC")
public class Funcionario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_FUNC", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_FUNCIONARIO", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO", nullable = false)
    private Cargo cargo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

}
