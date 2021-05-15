package com.samuel.bookstore.repositoriesTests;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import com.samuel.bookstore.model.Categoria;
import com.samuel.bookstore.model.Livro;
import com.samuel.bookstore.repositories.LivroRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Testes para Repositorio de Livro")
public class RepositorieLivroTests {

    @Autowired
    private LivroRepository livroRepository;

    @Test
    @DisplayName("Salvar e persistir Livro quando bem sucedido")
    void salvar_PersistirLivroQuandoBemSucedido(){
        Livro livroParaSalvar = criarLivro();
        Livro livroSalvo = this.livroRepository.save(livroParaSalvar);

        Assertions.assertThat(livroSalvo).isNotNull();
        Assertions.assertThat(livroSalvo.getId()).isNotNull();
        Assertions.assertThat(livroSalvo.getTitulo()).isNotNull();
        Assertions.assertThat(livroSalvo.getNomeAutor()).isNotNull();
        Assertions.assertThat(livroSalvo.getTitulo()).isEqualTo(livroParaSalvar.getTitulo());

    }

    @Test
    @DisplayName("Salvar throw ConstraintViolationException quando titulo for vazio")
    void salvar_ConstraintViolationExceptionQuandoTituloEVazio(){
        Livro livro =  new Livro();
        
        Assertions.assertThatThrownBy(() -> this.livroRepository.save(livro))
                  .isInstanceOf(ConstraintViolationException.class);
    }
    
    @Test
    @DisplayName("Salvar e atualizar livro quando bem sucedido")
    void salvar_AtualizaLivroQuandoBemSucedido() {
        Livro livroParaSalvar = criarLivro();
        Livro livroSalvo = this.livroRepository.save(livroParaSalvar);

        livroSalvo.setTitulo("Clean Code");

        Livro livroAtualizado = this.livroRepository.save(livroSalvo);

        Assertions.assertThat(livroAtualizado).isNotNull();
        Assertions.assertThat(livroAtualizado.getId()).isNotNull();
        Assertions.assertThat(livroAtualizado.getTitulo()).isEqualTo(livroSalvo.getTitulo());
    }

    @Test
    @DisplayName("Deletar e remover categoria quando bem sucedido")
    void deletar_RemoverCategoriaQuandoBemSucedido(){
        Livro livroParaSalvar = criarLivro();

        Livro livroSalvo = this.livroRepository.save(livroParaSalvar);

        this.livroRepository.delete(livroSalvo);

        Optional<Livro> livroOptional = this.livroRepository.findById(livroSalvo.getId());

        Assertions.assertThat(livroOptional).isEmpty();
  
    }

    
    @Test
    @DisplayName("Encontrar livro por id quando bem sucedido")
    void encontrar_PorIdLivroQuandoBemSucedido(){
        Livro livroParaSalvar = criarLivro();

        Livro livroSalvo = this.livroRepository.save(livroParaSalvar);

        Optional<Livro> livroOptional = this.livroRepository.findById(livroSalvo.getId());

        Assertions.assertThat(livroOptional)
                  .isNotEmpty()
                  .contains(livroSalvo);
    }

    @Test
    @DisplayName("Encontrar por id retorna empty quando nao for encontrado")
    void encontrar_PorIdRetornarEmpytQuandoNaoEncontrado(){

        Optional<Livro> livroOptional = this.livroRepository.findById(0);

        Assertions.assertThat(livroOptional).isEmpty();


    }

    private Livro criarLivro() {
        Categoria cat = new Categoria(null, "Livros de Java" , "Aprendendo JAVA");
        Livro livro = new Livro(null,"Linguagem de Programação Java", "SUN", "abcd", cat);
        return livro;
    }
    
}
