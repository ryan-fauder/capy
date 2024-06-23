package br.com.core.capy.produto.controller;

import br.com.core.capy.produto.model.ProdutoInput;
import br.com.core.capy.produto.model.ProdutoOutput;
import br.com.core.capy.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;


    @PostMapping()
    public ResponseEntity<ProdutoOutput> create(@RequestBody ProdutoInput input) {
        return ResponseEntity.ok(produtoService.create(input));
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoOutput>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoOutput> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoOutput> update(@PathVariable Long id, @RequestBody ProdutoInput input) {
        return ResponseEntity.ok(produtoService.update(id, input));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoService.delete(id);
    }


}
