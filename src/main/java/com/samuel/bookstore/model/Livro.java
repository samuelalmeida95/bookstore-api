package com.samuel.bookstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo TITULO é obrigatório!") 
    @Length(min = 3, max = 100, message = "Campo TITULO deve ter entre 3 e 100 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo NOME AUTOR é obrigatório!") 
    @Length(min = 3, max = 100, message = "Campo NOME AUTOR deve ter entre 3 e 100 caracteres")
    private String nomeAutor;


    private String texto;

    @JsonIgnore
    @ManyToOne //muitos para um
    @JoinColumn(name = "categoria_id") //coluna de juncao
    private Categoria categoria;


}
