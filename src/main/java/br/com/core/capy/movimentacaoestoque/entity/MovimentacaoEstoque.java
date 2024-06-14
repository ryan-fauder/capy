package br.com.core.capy.movimentacaoestoque.entity;

import br.com.core.capy.funcionario.entity.Funcionario;
import br.com.core.capy.produtoopcao.entity.ProdutoOpcao;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "MOVIMENTACAO_ESTOQUE")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_MOES", sequenceName = "SEQ_MOES")
public class MovimentacaoEstoque {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_MOES", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_MOVIMENTACAO_ESTOQUE", nullable = false)
    private Long id;

    @Column(name = "QUANTIDADE_DISPONIVEL", nullable = false)
    private int quantidadeDisponivel;

    @Column(name = "ORIGEM")
    private String origem;

    @Column(name = "VALOR_CUSTO", nullable = false)
    private BigDecimal valorCustoPorPeca;

    @Column(name = "UPDATE_AT", nullable = false)
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO", nullable = false, foreignKey = @ForeignKey(name = "FK_MOVIMENTACAOESTOQUE_FUNCIONARIO"))
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO_OPCAO", nullable = false, foreignKey = @ForeignKey(name = "FK_MOVIMENTACAOESTOQUE_PRODUTOOPCAO"))
    private ProdutoOpcao produtoOpcao;

}
