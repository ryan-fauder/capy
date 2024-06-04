package br.com.core.capy.avaliacao.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "AVALIACAO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_AVAL", sequenceName = "SEQ_AVAL")
public class Avaliacao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_AVAL", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_AVALIACAO", nullable = false)
    private Long id;

    @Column(name = "CLASSIFICACAO", nullable = false)
    private int classificacao;

    @Column(name = "COMENTARIO")
    private String comentario;
}
