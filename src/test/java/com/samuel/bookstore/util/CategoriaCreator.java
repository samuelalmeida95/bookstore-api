package com.samuel.bookstore.util;

import com.samuel.bookstore.model.Categoria;

public class CategoriaCreator {
    
    public static Categoria criarCategoria(){
        Categoria cat = new Categoria(null, "Testes", "Aprendendo sobre testes");
        return cat;
    }
}
