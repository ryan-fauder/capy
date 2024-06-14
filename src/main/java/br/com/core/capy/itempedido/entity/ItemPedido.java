package br.com.core.capy.itempedido.entity;

import br.com.core.capy.carrinho.entity.CarrinhoDeCompra;
import br.com.core.capy.pedido.entity.Pedido;
import br.com.core.capy.produtodescricao.entity.ProdutoDescricao;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ITEM_PEDIDO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_ITPE", sequenceName = "SEQ_ITPE")
public class ItemPedido {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_ITPE", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_ITEM_PEDIDO", nullable = false)
    private Long id;

    @Column(name = "QUANTIDADE_PEDIDO", nullable = false)
    private int quantidadePedido;

    @ManyToOne
    @JoinColumn(name = "COD_CARRINHO_DE_COMPRA", nullable = false, foreignKey = @ForeignKey(name = "FK_ITEM_CARRINHO"))
    private CarrinhoDeCompra carrinhoDeCompra;

    @ManyToOne
    @JoinColumn(name = "COD_PEDIDO", nullable = false, foreignKey = @ForeignKey(name = "FK_ITEMPEDIDO_PEDIDO"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO", nullable = false, foreignKey = @ForeignKey(name = "FK_ITEMPEDIDO_PRODUTODESCRICAO"))
    private ProdutoDescricao produtoDescricao;

}
