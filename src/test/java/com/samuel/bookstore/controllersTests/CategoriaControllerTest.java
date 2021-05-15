package com.samuel.bookstore.controllersTests;

import java.util.LinkedList;
import java.util.List;

import com.samuel.bookstore.controllers.CategoriaController;
import com.samuel.bookstore.dtos.CategoriaDTO;
import com.samuel.bookstore.model.Categoria;
import com.samuel.bookstore.services.CategoriaService;
import com.samuel.bookstore.util.CategoriaCreator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Testes para Controller de Categoira")
public class CategoriaControllerTest {

    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private CategoriaService categoriaServiceMock;

    @BeforeEach
    void setUp() {
        
        List<Categoria> categorias = new LinkedList<>(List.of(CategoriaCreator.criarCategoria()));
    
        BDDMockito.when(categoriaServiceMock.findAll()).thenReturn(categorias);
      
    }

    @Test
    @DisplayName("Lista retorna uma categoria dto quando bem sucedido")
    void list_RetornaListaDeCategoriasDTOQuandoBemSucedido() {
        String expectedName = CategoriaCreator.criarCategoria().getNome();

        List<CategoriaDTO> categorias = categoriaController.findAll().getBody();

        Assertions.assertThat(categorias).isNotNull();

        Assertions.assertThat(categorias).isNotEmpty();

        Assertions.assertThat(categorias.get(0).getNome()).isEqualTo(expectedName);

      
    }

}
