package com.samuel.bookstore.dtos;

import java.io.Serializable;

import com.samuel.bookstore.model.Categoria;
import lombok.Data;

@Data
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String descricao;
}