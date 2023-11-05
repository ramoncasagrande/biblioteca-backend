package com.unesc.bibliotecabackend.view.model;


public class LivroRequest {
    
        // #region Atributos


    private String titulo;
    private Integer isbn;
    private String resenha;
    private Integer numero_paginas;
    //#endregion

    //#region Getters Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public Integer getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(Integer numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    //#endregion
}
