package br.com.core.capy.avaliacao.entity;

import br.com.core.capy.produtodescricao.entity.ProdutoDescricao;
import br.com.core.capy.usuario.entity.Usuario;
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

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO", nullable = false, foreignKey = @ForeignKey(name = "FK_AVALIACAO_USUARIO"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO", nullable = false, foreignKey = @ForeignKey(name = "FK_AVALIACAO_PRODUTODESCRICAO"))
    private ProdutoDescricao produtoDescricao;
}
