package br.com.core.capy.itempedido.entity;

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

}
