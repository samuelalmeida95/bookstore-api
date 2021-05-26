package com.samuel.bookstore.dtos;

import java.io.Serializable;

import com.samuel.bookstore.model.Livro;

public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String titulo;
    private String nomeAutor;

    public LivroDTO(Livro obj) {
        this.titulo = obj.getTitulo();
        this.nomeAutor = obj.getNomeAutor();
        this.id = obj.getId();
    }

    public LivroDTO() {

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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
