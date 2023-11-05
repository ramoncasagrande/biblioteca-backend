package com.unesc.bibliotecabackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unesc.bibliotecabackend.model.Livro;
import com.unesc.bibliotecabackend.model.exception.ResourceNotFoundException;
import com.unesc.bibliotecabackend.repository.LivroRepository;
import com.unesc.bibliotecabackend.shared.LivroDTO;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    /**
     * Método para obter todos as livros
     * @return a lista de livros
     */
    public List<LivroDTO> obterTodos(){
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
            .map(livro -> new ModelMapper().map(livro, LivroDTO.class))
            .collect(Collectors.toList());
    }

    /**
     * Método para obter livro pelo ID
     * @param id do livro procurado
     * @return o livro procurado
     */
    public Optional<LivroDTO> obterPorId(Integer id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isEmpty()){
            throw new ResourceNotFoundException("Livro inexistente");
        }
        LivroDTO livroDTO = new ModelMapper().map(livro.get(), LivroDTO.class);
        return Optional.of(livroDTO);
    }

    /**
     * Método para adicionar livros
     * @param livro a ser adicionado
     * @return o livro adicionado
     */
    public LivroDTO adicionar(LivroDTO livroDTO){
        livroDTO.setId(null);
        ModelMapper mapper = new ModelMapper();
        Livro livro = mapper.map(livroDTO, Livro.class);
        livro = livroRepository.save(livro);
        livroDTO.setId(livro.getId());
        return livroDTO;
    }

    /**
     * Método para remover livros pelo ID
     * @param id do livro a ser removido
     */
    public void remover(Integer id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isEmpty()){
            throw new ResourceNotFoundException("Livro inexistente");
        }

        livroRepository.deleteById(id);
    }

    /**
     * Método para atualizar um livro
     * @param id do livro a ser atualizado
     * @param livro a ser atualizado
     * @return o livro atualizado
     */
    public LivroDTO atualizar(Integer id, LivroDTO livroDTO){
        //regra de negócio

        livroDTO.setId(id);
        ModelMapper mapper = new ModelMapper();
        Livro livro = mapper.map(livroDTO, Livro.class);
        livroRepository.save(livro);
        return livroDTO;
    }
}
