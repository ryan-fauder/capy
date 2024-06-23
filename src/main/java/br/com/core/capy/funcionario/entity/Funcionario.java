package br.com.core.capy.funcionario.entity;

import br.com.core.capy.cupom.entity.Cupom;
import br.com.core.capy.funcionario.enumx.Cargo;
import br.com.core.capy.estoque.entity.Estoque;
import br.com.core.capy.produto.entity.Produto;
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
@Table(name = "FUNCIONARIO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_FUNC", sequenceName = "SEQ_FUNC")
public class Funcionario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SEQ_FUNC", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD_FUNCIONARIO", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO", nullable = false)
    private Cargo cargo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "funcionario")
    private List<Produto> produtos = new ArrayList<>();

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "funcionario")
    private List<Cupom> cupoms = new ArrayList<>();

    @OneToMany(fetch = LAZY, cascade = ALL, orphanRemoval = true, mappedBy = "funcionario")
    private List<Estoque> estoques = new ArrayList<>();
}
