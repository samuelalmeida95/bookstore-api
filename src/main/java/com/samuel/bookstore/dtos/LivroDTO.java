package com.samuel.bookstore.dtos;

import java.io.Serializable;

import com.samuel.bookstore.model.Livro;
import lombok.Data;

@Data
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String titulo;
    private String nomeAutor;

}
