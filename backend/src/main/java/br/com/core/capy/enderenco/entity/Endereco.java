package br.com.core.capy.enderenco.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ENDERECO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_ENDE", sequenceName = "SEQ_ENDE")
public class Endereco {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_ENDE", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_ENDERECO", nullable = false)
    private Long id;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

}
