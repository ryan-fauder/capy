package br.com.core.capy.usuario.entity;

import jakarta.persistence.*;
import lombok.*;

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


}
