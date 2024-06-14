package br.com.core.capy.produtodescricao.entity;

import br.com.core.capy.avaliacao.entity.Avaliacao;
import br.com.core.capy.produtoopcao.enumx.Tamanho;
import br.com.core.capy.funcionario.entity.Funcionario;
import br.com.core.capy.itempedido.entity.ItemPedido;
import br.com.core.capy.produtodescricao.enumx.Estilo;
import br.com.core.capy.produtodescricao.enumx.Genero;
import br.com.core.capy.produtoopcao.entity.ProdutoOpcao;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PRODUTO_DESCRICAO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_PROD", sequenceName = "SEQ_PROD")
public class ProdutoDescricao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_PROD", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_PRODUTO_DESCRICAO", nullable = false)
    private Long id;

    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "MARCA")
    private Tamanho marca;

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

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUTO_FUNCIONARIO"))
    private Funcionario funcionario;

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "produtoDescricao")
    private List<Avaliacao> avaliacaos = new ArrayList<>();

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "produtoDescricao")
    private List<ItemPedido> itemPedidos = new ArrayList<>();

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "produtoDescricao")
    private List<ProdutoOpcao> produtoOpcaos = new ArrayList<>();


}
