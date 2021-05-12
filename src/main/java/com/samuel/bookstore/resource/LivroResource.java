package com.samuel.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
    
    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll() {
        List<Livro> list = service.findAll();
        List<LivroDTO> listDTO = list.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);    
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        livro = service.create(livro);

        URI uri = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("{id}")
                  .buildAndExpand(livro.getId())
                  .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @RequestBody LivroDTO livroDTO){
        Livro newLivro = service.update(id, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(newLivro));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
