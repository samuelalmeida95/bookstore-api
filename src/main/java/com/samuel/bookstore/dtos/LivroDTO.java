package com.samuel.bookstore.dtos;

import com.samuel.bookstore.domain.Livro;

public class LivroDTO {

    private String titulo;
    private String nomeAutor;

    public LivroDTO(Livro obj) {
        this.titulo = obj.getTitulo();
        this.nomeAutor = obj.getNomeAutor();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

}
