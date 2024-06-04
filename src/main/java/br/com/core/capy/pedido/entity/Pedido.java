package br.com.core.capy.pedido.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PEDIDO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_PEDI", sequenceName = "SEQ_PEDI")
public class Pedido {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_PEDI", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_PEDIDO", nullable = false)
    private Long id;

    @Column(name = "STATUS", nullable = false)
    private String status;


}
