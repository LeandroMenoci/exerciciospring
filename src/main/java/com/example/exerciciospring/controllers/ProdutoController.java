package com.example.exerciciospring.controllers;

import com.example.exerciciospring.model.entities.Produto;
import com.example.exerciciospring.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // @PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/pagina/{numeroPagina}/{qtdePagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
        if(qtdePagina >= 5) qtdePagina = 5;
        PageRequest page = PageRequest.of(numeroPagina, qtdePagina);
        return produtoRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

    // @PutMapping
    // public Produto alterarProduto(@Valid Produto produto){
    //     produtoRepository.save(produto);
    //     return produto;
    // }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }
}
