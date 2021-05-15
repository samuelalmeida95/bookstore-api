package com.samuel.bookstore.repositoriesTests;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

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
    void salvar_PersistirCategoriaQuandoBemSucedido(){
        Categoria categoriaParaSerSalva = criarCategoria();
        Categoria categoriaSalva = this.categoriaRepository.save(categoriaParaSerSalva);

        Assertions.assertThat(categoriaSalva).isNotNull();
        Assertions.assertThat(categoriaSalva.getId()).isNotNull();
        Assertions.assertThat(categoriaSalva.getNome()).isNotNull();
        Assertions.assertThat(categoriaSalva.getDescricao()).isNotNull();
        Assertions.assertThat(categoriaSalva.getNome()).isEqualTo(categoriaParaSerSalva.getNome());
  
    }

    @Test
    @DisplayName("Salvar throw ConstraintViolationException quando nome for vazio")
    void salvar_ConstraintViolationExceptionQuandoNomeEVazio(){
        Categoria categoria =  new Categoria();
        
        Assertions.assertThatThrownBy(() -> this.categoriaRepository.save(categoria))
                  .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("Salvar e atualizar categoria quando bem sucedido")
    void salvar_AtualizarCategoriaQuandoBemSucedido(){
        Categoria categoriaParaSerSalva = criarCategoria();

        Categoria categoriaSalva = this.categoriaRepository.save(categoriaParaSerSalva);

        categoriaSalva.setNome("Auto Ajuda");

        Categoria categoriaAtulizada = this.categoriaRepository.save(categoriaSalva);

        Assertions.assertThat(categoriaAtulizada).isNotNull();
        Assertions.assertThat(categoriaAtulizada.getId()).isNotNull();
        Assertions.assertThat(categoriaAtulizada.getNome()).isEqualTo(categoriaSalva.getNome());
  
    }

    @Test
    @DisplayName("Deletar e remover categoria quando bem sucedido")
    void deletar_RemoverCategoriaQuandoBemSucedido(){
        Categoria categoriaParaSerSalva = criarCategoria();

        Categoria categoriaSalva = this.categoriaRepository.save(categoriaParaSerSalva);

        this.categoriaRepository.delete(categoriaSalva);

        Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(categoriaSalva.getId());

        Assertions.assertThat(categoriaOptional).isEmpty();
  
    }

    @Test
    @DisplayName("Encontrar categoria por id quando bem sucedido")
    void encontrar_PorIdCategoriaQuandoBemSucedido(){
        Categoria categoriaParaSerSalva = criarCategoria();

        Categoria categoriaSalva = this.categoriaRepository.save(categoriaParaSerSalva);

        Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(categoriaSalva.getId());

        Assertions.assertThat(categoriaOptional)
                  .isNotEmpty()
                  .contains(categoriaSalva);
       
    }

    @Test
    @DisplayName("Encontrar por id retorna empty quando nao for encontrado")
    void encontrar_PorIdRetornarEmptyQuandoNaoEncontrado(){

        Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(-1);

        Assertions.assertThat(categoriaOptional).isEmpty();
    }


    private Categoria criarCategoria(){
        Categoria cat = new Categoria(null, "Testes", "Aprendendo sobre testes");
        return cat;
    }

}
