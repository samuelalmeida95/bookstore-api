package com.samuel.bookstore.modelTest;

import com.samuel.bookstore.model.Categoria;
import com.samuel.bookstore.model.Livro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LivroModelTests {
    

    @Test
    public void cria_LivroVazioRetornaNullQuandoBemSucedido() {
        Livro l1 = new Livro();

        Assertions.assertThat(l1.getId()).isNull();
        
        Assertions.assertThat(l1.getTitulo()).isNull();

        Assertions.assertThat(l1.getNomeAutor()).isNull();

        Assertions.assertThat(l1.getTexto()).isNull();

        Assertions.assertThat(l1.getCategoria()).isNull();
    }

    @Test
    public void cria_LivroNaoPodeSerNullQuandoBemSucedido() {
        Categoria cat1 = new Categoria();
        Livro l1 = new Livro(2, "Java 8", "SUN", "txtxtx", cat1);

        Assertions.assertThat(l1.getId()).isNotNull();
        
        Assertions.assertThat(l1.getTitulo()).isNotNull();

        Assertions.assertThat(l1.getNomeAutor()).isNotNull();

        Assertions.assertThat(l1.getTexto()).isNotNull();

        Assertions.assertThat(l1.getCategoria()).isNotNull();

        Assertions.assertThat(l1.getTitulo()).isEqualTo("Java 8");
    }
}
