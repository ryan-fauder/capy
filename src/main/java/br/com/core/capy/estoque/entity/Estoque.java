package br.com.core.capy.estoque.entity;

import br.com.core.capy.estoque.enumx.Tamanho;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ESTOQUE")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_ESTO", sequenceName = "SEQ_ESTO")
public class Estoque {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_ESTO", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_ESTOQUE", nullable = false)
    private Long id;

    @Column(name = "QUANTIDADE_DISPONIVEL", nullable = false)
    private int quantidadeDisponivel;

    @Column(name = "ORIGEM")
    private String origem;

    @Enumerated(EnumType.STRING)
    @Column(name = "TAMANHO", nullable = false)
    private Tamanho tamanho;

    @Column(name = "COR", nullable = false)
    private String cor;

    @Column(name = "VALOR_VENDA", nullable = false)
    private BigDecimal valorVendaPorPeca;

    @Column(name = "VALOR_CUSTO", nullable = false)
    private BigDecimal valorCustoPorPeca;

    @Column(name = "UPDATE_AT", nullable = false)
    private LocalDate updatedAt;

}
