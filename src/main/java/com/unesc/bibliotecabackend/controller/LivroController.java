package com.unesc.bibliotecabackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unesc.bibliotecabackend.model.Livro;
import com.unesc.bibliotecabackend.service.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> obterTodos(){
        return livroService.obterTodos();
    }

    @PostMapping
    public Livro adicionar(@RequestBody Livro livro){
        return livroService.adicionar(livro);
    }

    @GetMapping("/{id}")
    public Optional<Livro> obterPorId(@PathVariable Integer id){
        return livroService.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Integer id){
        livroService.remover(id);
        return "Livro Excluído: id=" + id;
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Integer id, @RequestBody Livro livro){
        return livroService.atualizar(id, livro);
    }

}
