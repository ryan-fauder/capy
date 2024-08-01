package br.com.core.capy.usuario.entity;

import br.com.core.capy.avaliacao.entity.Avaliacao;
import br.com.core.capy.carrinho.entity.CarrinhoDeCompra;
import br.com.core.capy.cupom.entity.Cupom;
import br.com.core.capy.enderenco.entity.Endereco;
import br.com.core.capy.pedido.entity.Pedido;
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
@Table(name = "USUARIO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_USER", sequenceName = "SEQ_USER")
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_USER", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_USUARIO", nullable = false)
    private Long id;

    @Column(name = "CONTATO")
    private String contato;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "COD_ENDERECO", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_ENDERECO"))
    private Endereco endereco;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "COD_CARRINHO_DE_COMPRA", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_CARRINHO"))
    private CarrinhoDeCompra carrinhoDeCompra;

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "usuario")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "usuario")
    private List<Avaliacao> avaliacaos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "USUARIO_CUPOM",
            joinColumns = { @JoinColumn(name = "COD_USUARIO") },
            inverseJoinColumns = {@JoinColumn(name = "COD_CUPOM") })
    private List<Cupom> cupoms;

}
