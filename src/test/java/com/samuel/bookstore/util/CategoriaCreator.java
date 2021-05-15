package com.samuel.bookstore.util;

import com.samuel.bookstore.model.Categoria;

public class CategoriaCreator {
    
    public static Categoria criarCategoria(){
        Categoria cat = new Categoria(2, "Testes", "Aprendendo sobre testes");
        return cat;
    }
}
