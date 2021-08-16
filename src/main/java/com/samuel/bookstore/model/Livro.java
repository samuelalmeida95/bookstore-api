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

import org.hibernate.validator.constraints.Length;

@Entity
public class Livro implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotEmpty(message = "Campo TITULO é obrigatório!")
  @Length(min = 3, max = 100, message = "Campo TITULO deve ter entre 3 e 50 caracteres")
  private String titulo;

  @NotEmpty(message = "Campo NOME AUTOR é obrigatório!")
  @Length(min = 3, max = 100, message = "Campo NOME AUTOR deve ter entre 3 e 100 caracteres")
  private String nomeAutor;

  @NotEmpty(message = "Campo TEXTO é obrigatório!")
  @Length(min = 3, max = 100, message = "Campo TEXTO deve ter entre 3 e 100 caracteres")
  private String texto;

  @JsonIgnore
  @ManyToOne // muitos para um
  @JoinColumn(name = "categoria_id") // coluna de juncao
  private Categoria categoria;

  public Livro(
    Integer id,
    String titulo,
    String nomeAutor,
    String texto,
    Categoria categoria
  ) {
    this.id = id;
    this.titulo = titulo;
    this.nomeAutor = nomeAutor;
    this.texto = texto;
    this.categoria = categoria;
  }

  public Livro() {}

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
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
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Livro other = (Livro) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
