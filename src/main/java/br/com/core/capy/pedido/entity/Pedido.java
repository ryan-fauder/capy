package br.com.core.capy.pedido.entity;

import br.com.core.capy.avaliacao.entity.Avaliacao;
import br.com.core.capy.enderenco.entity.Endereco;
import br.com.core.capy.itempedido.entity.ItemPedido;
import br.com.core.capy.pagamento.entity.Pagamento;
import br.com.core.capy.usuario.entity.Usuario;
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

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO", nullable = false, foreignKey = @ForeignKey(name = "FK_PEDIDO_USUARIO"))
    private Usuario usuario;

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "pedido")
    private List<ItemPedido> itemPedidos = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "COD_PAGAMENTO", nullable = false, foreignKey = @ForeignKey(name = "FK_PEDIDO_PAGAMENTO"))
    private Pagamento pagamento;
}
