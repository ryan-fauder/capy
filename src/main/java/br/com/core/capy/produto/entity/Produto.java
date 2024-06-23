package br.com.core.capy.produto.entity;

import br.com.core.capy.avaliacao.entity.Avaliacao;
import br.com.core.capy.estoque.entity.Estoque;
import br.com.core.capy.funcionario.entity.Funcionario;
import br.com.core.capy.itempedido.entity.ItemPedido;
import br.com.core.capy.produto.enumx.Estilo;
import br.com.core.capy.produto.enumx.Genero;
import br.com.core.capy.produto.enumx.Tamanho;
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
@Table(name = "PRODUTO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_PROD", sequenceName = "SEQ_PROD")
public class Produto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_PROD", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_PRODUTO", nullable = false)
    private Long id;

    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTILO")
    private Estilo estilo;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENERO")
    private Genero genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "TAMANHO", nullable = false)
    private Tamanho tamanho;

    @Column(name = "COR", nullable = false)
    private String cor;

    @Column(name = "VALOR_VENDA", nullable = false)
    private BigDecimal valorVendaPorPeca;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "COD_ESTOQUE", foreignKey = @ForeignKey(name = "FK_PRODUTO_ESTOQUE"))
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO", foreignKey = @ForeignKey(name = "FK_PRODUTO_FUNCIONARIO"))
    private Funcionario funcionario;

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "produto")
    private List<Avaliacao> avaliacaos = new ArrayList<>();

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "produto")
    private List<ItemPedido> itemPedidos = new ArrayList<>();

}
