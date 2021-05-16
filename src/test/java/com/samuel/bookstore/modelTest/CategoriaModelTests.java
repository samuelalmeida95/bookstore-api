package com.samuel.bookstore.modelTest;

import com.samuel.bookstore.model.Categoria;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoriaModelTests {

    @Test
    public void criar_CategoriaVaziaRetonaNullQuandoBemSucedido() {
        Categoria c1 = new Categoria();

        Assertions.assertThat(c1.getNome()).isNull();

        Assertions.assertThat(c1.getDescricao()).isNull();

        Assertions.assertThat(c1.getId()).isNull();
    }

    @Test
    public void criar_CriaNovaCategoriaNaoPodeSerNullQuandoBemSucedido() {
        Categoria c1 = new Categoria(1, "Culinaria", "Livros de culinaria");

        Assertions.assertThat(c1.getNome()).isNotNull();

        Assertions.assertThat(c1.getDescricao()).isNotNull();

        Assertions.assertThat(c1.getId()).isNotNull();

        Assertions.assertThat(c1.getNome()).isEqualTo("Culinaria");

        Assertions.assertThat(c1.getId()).isEqualTo(1);

        Assertions.assertThat(c1.getDescricao()).isEqualTo("Livros de culinaria");

    }
}
