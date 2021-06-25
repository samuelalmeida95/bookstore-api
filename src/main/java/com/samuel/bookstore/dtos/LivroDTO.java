package com.samuel.bookstore.dtos;

import java.io.Serializable;

import com.samuel.bookstore.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String titulo;

    private String nomeAutor;

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.nomeAutor = obj.getNomeAutor();
    }

}
