package br.com.core.capy.produto.entity;

import br.com.core.capy.estoque.enumx.Tamanho;
import br.com.core.capy.produto.enumx.Estilo;
import br.com.core.capy.produto.enumx.Genero;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PRODUTO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_PROD", sequenceName = "SEQ_PROD")
public class Produto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_PROD", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_PRODUTO", nullable = false)
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

}
