package br.com.core.capy.produto.service;

import br.com.core.capy.estoque.entity.Estoque;
import br.com.core.capy.produto.entity.Produto;
import br.com.core.capy.produto.mapper.ProdutoMapper;
import br.com.core.capy.produto.model.ProdutoInput;
import br.com.core.capy.produto.model.ProdutoOutput;
import br.com.core.capy.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    private final ProdutoMapper produtoMapper;

    public ProdutoOutput create(ProdutoInput produtoInput) {
        Produto produto = produtoMapper.toEntity(produtoInput);
        produto.setEstoque(produtoInput.getEstoque() == null ? new Estoque() : produtoInput.getEstoque());
        return produtoMapper.toOutput(produtoRepository.save(produto));
    }

    public List<ProdutoOutput> findAll() {
        return produtoRepository.findAll().stream().map(produtoMapper::toOutput).toList();
    }

    public ProdutoOutput findById(Long id) {
        return produtoRepository.findById(id).map(produtoMapper::toOutput).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
    }

    public ProdutoOutput update(Long id, ProdutoInput produtoInput) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
        produtoMapper.update(produtoInput, produto);
        return produtoMapper.toOutput(produtoRepository.save(produto));
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
