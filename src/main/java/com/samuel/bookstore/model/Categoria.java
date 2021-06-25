package com.samuel.bookstore.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME é obrigatório!") 
    @Length(min = 3, max = 100, message = "Campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo NOME é obrigatório!") 
    @Length(min = 3, max = 100, message = "Campo NOME deve ter entre 3 e 100 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "categoria") // um para muitos
    private List<Livro> livros = new LinkedList<>();
}
