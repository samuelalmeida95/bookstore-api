package com.samuel.bookstore.services;

import java.util.List;
import java.util.Optional;

import com.samuel.bookstore.domain.Categoria;
import com.samuel.bookstore.dtos.CategoriaDTO;
import com.samuel.bookstore.repositories.CategoriaRepository;
import com.samuel.bookstore.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    // busca por id
    public Categoria findById(Integer idCategoria) {
        Optional<Categoria> obj = repository.findById(idCategoria);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!  Id: " + idCategoria + " Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer idCategoria, CategoriaDTO objDto) {
        Categoria obj = findById(idCategoria);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer idCategoria) {
        findById(idCategoria);
        try {
            repository.deleteById(idCategoria);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada, possui livros associados");
        }
    }

}
