package br.com.core.capy.produto.mapper;

import br.com.core.capy.produto.entity.Produto;
import br.com.core.capy.produto.model.ProdutoInput;
import br.com.core.capy.produto.model.ProdutoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProdutoMapper {

    Produto toEntity (ProdutoInput input);

    ProdutoOutput toOutput (Produto produto);

    void update(ProdutoInput input, @MappingTarget Produto produto);
}
