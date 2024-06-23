package br.com.core.capy.estoque.entity;
import br.com.core.capy.carrinho.entity.CarrinhoDeCompra;
import br.com.core.capy.funcionario.entity.Funcionario;
import br.com.core.capy.produto.entity.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

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

    @Column(name = "QUANTIDADE", nullable = false)
    private int quantidade;

    @Column(name = "ORIGEM")
    private String origem;

    @Column(name = "VALOR_CUSTO", nullable = false)
    private BigDecimal valorCustoPorPeca;

    @Column(name = "UPDATE_AT", nullable = false)
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO", nullable = false, foreignKey = @ForeignKey(name = "FK_ESTOQUE_FUNCIONARIO"))
    private Funcionario funcionario;

}
