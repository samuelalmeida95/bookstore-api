package com.samuel.bookstore.services;

import java.util.Optional;

import com.samuel.bookstore.domain.Categoria;
import com.samuel.bookstore.repositories.CategoriaRepository;
import com.samuel.bookstore.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    // busca por id
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!  Id: " + id + " Tipo: " + Categoria.class.getName()));
    }
}
