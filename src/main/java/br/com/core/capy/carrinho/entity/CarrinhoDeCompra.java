package br.com.core.capy.carrinho.entity;

import br.com.core.capy.cupom.entity.Cupom;
import br.com.core.capy.itempedido.entity.ItemPedido;
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
@Table(name = "CARRINHO_DE_COMPRA")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_CARC", sequenceName = "SEQ_CARC")
public class CarrinhoDeCompra {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_CARC", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_CARRINHO_DE_COMPRA", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(name = "CARRINHO_CUPOM",
            joinColumns = { @JoinColumn(name = "COD_CARRINHO_DE_COMPRA") },
            inverseJoinColumns = {@JoinColumn(name = "COD_CUPOM") })
    private List<Cupom> cupoms;

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "carrinhoDeCompra")
    private List<ItemPedido> itemPedidos = new ArrayList<>();

}
