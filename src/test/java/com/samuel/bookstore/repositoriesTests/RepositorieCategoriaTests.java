package com.samuel.bookstore.repositoriesTests;

import com.samuel.bookstore.model.Categoria;
import com.samuel.bookstore.repositories.CategoriaRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Testes para Repositorio de Categoria")
public class RepositorieCategoriaTests {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @DisplayName("Salvar e persistir categoria quando bem sucedido")
    void salva_PersistirCategoriaQuandoBemSucedido(){
        Categoria categoriaParaSerSalva = criarCategoria();
        Categoria categoriaSalva = this.categoriaRepository.save(categoriaParaSerSalva);

        Assertions.assertThat(categoriaSalva).isNotNull();
        Assertions.assertThat(categoriaSalva.getId()).isNotNull();
        Assertions.assertThat(categoriaSalva.getNome()).isNotNull();
        Assertions.assertThat(categoriaSalva.getDescricao()).isNotNull();
        Assertions.assertThat(categoriaSalva.getNome()).isEqualTo(categoriaParaSerSalva.getNome());
  
    }

    @Test
    @DisplayName("Salvar e atualizar categoria quando bem sucedido")
    void salva_AtualizarCategoriaQuandoBemSucedido(){
        Categoria categoriaParaSerSalva = criarCategoria();

        Categoria categoriaSalva = this.categoriaRepository.save(categoriaParaSerSalva);

        categoriaSalva.setNome("Auto Ajuda");

        Categoria categoriaAtulizada = this.categoriaRepository.save(categoriaSalva);

        Assertions.assertThat(categoriaAtulizada).isNotNull();
        Assertions.assertThat(categoriaAtulizada.getId()).isNotNull();
        Assertions.assertThat(categoriaAtulizada.getNome()).isEqualTo(categoriaSalva.getNome());
  
    }


    private Categoria criarCategoria(){
        Categoria cat = new Categoria(null, "Testes", "Aprendendo sobre testes");
        return cat;
    }

}
