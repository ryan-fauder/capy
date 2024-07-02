package br.com.core.capy.estoque.entity;

import br.com.core.capy.funcionario.entity.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ESTOQUE")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_ESTO", sequenceName = "SEQ_ESTO")
public class Estoque {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_ESTO", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_ESTOQUE", nullable = false)
    private Long id;

    @Column(name = "QUANTIDADE", nullable = false, columnDefinition = "integer default 0")
    private int quantidade = 0;

    @Column(name = "ORIGEM")
    private String origem;

    @Column(name = "UPDATE_AT", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate updatedAt = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO", foreignKey = @ForeignKey(name = "FK_ESTOQUE_FUNCIONARIO"))
    private Funcionario funcionario;

}
