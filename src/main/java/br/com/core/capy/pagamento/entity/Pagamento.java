package br.com.core.capy.pagamento.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PAGAMENTO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_PAGA", sequenceName = "SEQ_PAGA")
public class Pagamento {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_PAGA", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_PAGAMENTO", nullable = false)
    private Long id;

    @Column(name = "NUMERO_CARTAP", nullable = false)
    private String numeroCartao;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DATA_VALIDADE", nullable = false)
    private String dataValidade;
}
