package com.samuel.bookstore.services;

import java.util.List;
import java.util.Optional;

import com.samuel.bookstore.domain.Livro;
import com.samuel.bookstore.dtos.LivroDTO;
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

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Livro create(Livro livro) {
        livro.setId(null);
        return repository.save(livro);
    }

    public Livro update(Integer id, LivroDTO livroDTO) {
      Livro livro = findById(id);
      livro.setTitulo(livroDTO.getTitulo());
      livro.setNomeAutor(livroDTO.getNomeAutor());
      return repository.save(livro);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

}
