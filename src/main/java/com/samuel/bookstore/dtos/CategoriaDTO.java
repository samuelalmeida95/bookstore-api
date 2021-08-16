package com.samuel.bookstore.dtos;

import java.io.Serializable;

import com.samuel.bookstore.model.Categoria;


public class CategoriaDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;
  private String descricao;

  public CategoriaDTO(Categoria obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.descricao = obj.getDescricao();
  }

  public Integer getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
