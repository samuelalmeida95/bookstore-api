package com.samuel.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.samuel.bookstore.domain.Livro;
import com.samuel.bookstore.dtos.LivroDTO;
import com.samuel.bookstore.services.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
    
    @Autowired
    private LivroService service;

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer idLivro){
        Livro livro = service.findById(idLivro);
        LivroDTO livroDTO = new LivroDTO(livro);
        return ResponseEntity.ok(livroDTO);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll() {
        List<Livro> list = service.findAll();
        List<LivroDTO> listDTO = list.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);    
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Livro> create(
        @RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria,
        @Valid  @RequestBody Livro livro) {

        Livro newLivro = service.create(idCategoria, livro);

        URI uri = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("/livros/{id}")
        .buildAndExpand(newLivro.getId())
        .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{idLivro}")
    public ResponseEntity<Livro> update(
        @PathVariable Integer idCategoria, 
        @PathVariable Integer idLivro,
        @RequestBody Livro livro) {

        Livro newLivro = service.update(idCategoria, idLivro, livro);
        return ResponseEntity.ok().body(newLivro);
    }


    @DeleteMapping(value = "/{idLivro}")
    public ResponseEntity<Void> delete(@PathVariable Integer idLivro) {
        service.delete(idLivro);
        return ResponseEntity.noContent().build();
    }
}
