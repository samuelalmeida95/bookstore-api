package com.samuel.bookstore.repositoriesTests;

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

    private Livro criarLivro() {
        Categoria cat = new Categoria(null, "Livros de Java" , "Aprendendo JAVA");
        Livro livro = new Livro(null,"Linguagem de Programação Java", "SUN", "abcd", cat);
        return livro;
    }
    
}
