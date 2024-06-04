package br.com.core.capy.carrinho.entity;

import jakarta.persistence.*;
import lombok.*;

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

}
