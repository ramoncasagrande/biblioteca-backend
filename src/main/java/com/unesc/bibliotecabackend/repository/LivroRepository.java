package com.unesc.bibliotecabackend.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.unesc.bibliotecabackend.model.Livro;

@Repository
public class LivroRepository {

    private List<Livro> livros = new ArrayList<Livro>();
    private Integer ultimoLivro = 0;


    /**
     * Método para listar todos os livros
     * @return Lista de livros
     */
    public List<Livro> obterTodos(){
        return livros;
    }

    /**
     * Método para retornar um livro pelo ID
     * @param id do livro a ser pesquisado
     * @return Retorna um livro
     */
    public Optional<Livro> obterPorId( Integer id){
        return livros.stream().filter(livro -> livro.getId() == id).findFirst();
    }

    /**
     * Método para adicionar livros
     * @param livro a ser adicionado
     * @return o livro adicionado
     */
    public Livro adicionar(Livro livro){
        ultimoLivro++;
        livro.setId(ultimoLivro);
        livros.add(livro);
        return livro;
    }

    /**
     * Método para remover um livro pelo ID
     * @param id do livro a ser removido
     */
    public void remover(Integer id){
        livros.removeIf(livro -> livro.getId() == id);
    }

    /**
     * Método para atualizar um livro
     * @param livro a ser atualizado
     * @return o livro atualizado
     */
    public Livro atualizar(Livro livro){
        //Pesquisar o livro a ser atualizado
        Optional<Livro> livroEncontrado = obterPorId(livro.getId());
        if (livroEncontrado.isEmpty()){
            throw new InputMismatchException("Livro não encontrado");
        }

        //Remover livro antigo
        remover(livro.getId());

        //Adicionar novo livro
        livros.add(livro);

        return livro;
    }

    
}
