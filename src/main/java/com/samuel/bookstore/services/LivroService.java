package com.samuel.bookstore.services;

import java.util.Optional;

import com.samuel.bookstore.domain.Livro;
import com.samuel.bookstore.repositories.LivroRepository;
import com.samuel.bookstore.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!  Id: " + id + " Tipo: " + Livro.class.getName()));
    }

}
