package br.com.core.capy.produtoopcao.entity;

import br.com.core.capy.funcionario.entity.Funcionario;
import br.com.core.capy.itempedido.entity.ItemPedido;
import br.com.core.capy.movimentacaoestoque.entity.MovimentacaoEstoque;
import br.com.core.capy.produtodescricao.entity.ProdutoDescricao;
import br.com.core.capy.produtoopcao.enumx.Tamanho;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PRODUTO_OPCAO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_PROO", sequenceName = "SEQ_PROO")
public class ProdutoOpcao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_PROO", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_PRODUTO_OPCAO", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TAMANHO", nullable = false)
    private Tamanho tamanho;

    @Column(name = "COR", nullable = false)
    private String cor;

    @Column(name = "VALOR_VENDA", nullable = false)
    private BigDecimal valorVendaPorPeca;

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "produtoOpcao")
    private List<MovimentacaoEstoque> movimentacaoEstoques = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO_DESCRICAO", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUTOOPCAO_PRODUTODESCRICAO"))
    private ProdutoDescricao produtoDescricao;


}
