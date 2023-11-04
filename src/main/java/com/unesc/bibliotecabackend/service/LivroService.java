package com.unesc.bibliotecabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unesc.bibliotecabackend.model.Livro;
import com.unesc.bibliotecabackend.repository.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    /**
     * Método para obter todos as livros
     * @return a lista de livros
     */
    public List<Livro> obterTodos(){
        return livroRepository.obterTodos();
    }

    /**
     * Método para obter livro pelo ID
     * @param id do livro procurado
     * @return o livro procurado
     */
    public Optional<Livro> obterPorId(Integer id){
        return livroRepository.obterPorId(id);
    }

    /**
     * Método para adicionar livros
     * @param livro a ser adicionado
     * @return o livro adicionado
     */
    public Livro adicionar(Livro livro){
        return livroRepository.adicionar(livro);
    }

    /**
     * Método para remover livros pelo ID
     * @param id do livro a ser removido
     */
    public void remover(Integer id){
        livroRepository.remover(id);
    }

    /**
     * Método para atualizar um livro
     * @param id do livro a ser atualizado
     * @param livro a ser atualizado
     * @return o livro atualizado
     */
    public Livro atualizar(Integer id, Livro livro){
        //regra de negócio
        livro.setId(id);
        return livroRepository.atualizar(livro);
    }
}
