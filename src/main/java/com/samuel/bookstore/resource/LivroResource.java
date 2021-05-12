package com.samuel.bookstore.resource;

import java.util.List;

import com.samuel.bookstore.domain.Livro;
import com.samuel.bookstore.services.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Livro>> findAll() {
        List<Livro> list = service.findAll();
        return ResponseEntity.ok().body(list);
        
    }

}
