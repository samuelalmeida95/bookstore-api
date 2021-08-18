package com.samuel.bookstore.services;

import com.samuel.bookstore.model.Categoria;
import com.samuel.bookstore.model.Livro;
import com.samuel.bookstore.repositories.LivroRepository;
import com.samuel.bookstore.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

  @Autowired
  private LivroRepository repository;

  @Autowired
  private CategoriaService categoriaService;

  public Livro findById(Integer idLivro) {
    Optional<Livro> obj = repository.findById(idLivro);
    return obj.orElseThrow(
      () ->
        new ObjectNotFoundException(
          "Objeto não encontrado!  Id: " +
          idLivro +
          " Tipo: " +
          Livro.class.getName()
        )
    );
  }

  public List<Livro> findAll() {
    return repository.findAll();
  }

  public Livro create(Integer idCategoria, Livro livro) {
    livro.setId(null);
    Categoria categoria = categoriaService.findById(idCategoria);
    livro.setCategoria(categoria);
    return repository.save(livro);
  }

  public Livro update(Integer idCategoria, Integer idLivro, Livro livro) {
    Optional<Livro> opLivro = repository.findByIdAndCategoriaId(
      idLivro,
      idCategoria
    );

    if (opLivro.isPresent()) {
      Livro newlivro = updateData(opLivro.get(), livro);
      return repository.save(newlivro);
    }

    throw new ObjectNotFoundException(
      "Objeto não encontrado! Id: " +
      idLivro +
      ", Tipo: " +
      Livro.class.getName()
    );
  }

  private Livro updateData(Livro livro, Livro novoLivro) {
    livro.setTitulo(novoLivro.getTitulo());
    livro.setNomeAutor(novoLivro.getNomeAutor());
    return livro;
  }

  public void delete(Integer idLivro) {
    findById(idLivro);
    repository.deleteById(idLivro);
  }
}
