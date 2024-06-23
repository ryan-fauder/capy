package br.com.core.capy.produto.model;

import br.com.core.capy.produto.enumx.Estilo;
import br.com.core.capy.produto.enumx.Genero;
import br.com.core.capy.produto.enumx.Tamanho;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProdutoInput {

    private String codigo;

    private String nome;

    private String marca;

    private String material;

    private String descricao;

    private Estilo estilo;

    private Genero genero;

    private Tamanho tamanho;

    private String cor;

    private BigDecimal valorVendaPorPeca;

}
