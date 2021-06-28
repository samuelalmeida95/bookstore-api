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

import org.hibernate.validator.constraints.Length;

@Entity
public class Categoria implements Serializable {

    public Categoria(Object object, String string, String string2) {
    }

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

    public Categoria(Integer id,
            @NotEmpty(message = "Campo NOME é obrigatório!") @Length(min = 3, max = 100, message = "Campo NOME deve ter entre 3 e 100 caracteres") String nome,
            @NotEmpty(message = "Campo NOME é obrigatório!") @Length(min = 3, max = 100, message = "Campo NOME deve ter entre 3 e 100 caracteres") String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
