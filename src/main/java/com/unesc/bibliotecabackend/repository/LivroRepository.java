package com.unesc.bibliotecabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unesc.bibliotecabackend.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

    
} 
