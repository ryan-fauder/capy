package br.com.core.capy.cupom.entity;

import br.com.core.capy.carrinho.entity.CarrinhoDeCompra;
import br.com.core.capy.funcionario.entity.Funcionario;
import br.com.core.capy.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CUPOM")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_CUPO", sequenceName = "SEQ_CUPO")
public class Cupom {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_CUPO", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_CUPOM", nullable = false)
    private Long id;

    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @Column(name = "DESCONTO", nullable = false)
    private BigDecimal desconto;

    @Column(name = "DATA_VALIDADE")
    private LocalDate dataValidade;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO", nullable = false, foreignKey = @ForeignKey(name = "FK_CUPOM_FUNCIONARIO"))
    private Funcionario funcionario;

    @ManyToMany(mappedBy = "cupoms")
    List<CarrinhoDeCompra> carrinhoDeCompras;

    @ManyToMany(mappedBy = "cupoms")
    List<Usuario> usuarios;
}
