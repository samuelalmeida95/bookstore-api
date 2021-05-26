package com.samuel.bookstore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.samuel.bookstore.dtos.CategoriaDTO;
import com.samuel.bookstore.model.Categoria;
import com.samuel.bookstore.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{idCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer idCategoria) {
        Categoria obj = service.findById(idCategoria);
        
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = service.findAll();

        List<CategoriaDTO> listDTO = list
                .stream()
                .map(categoria -> new CategoriaDTO(categoria))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria categoria) {
        Categoria cadastrarCategoria = service.create(categoria);

        return cadastrarCategoria;
    }

    @PutMapping(value = "/{idCategoria}")
    public ResponseEntity<CategoriaDTO> update(
        @PathVariable Integer idCategoria, 
        @RequestBody CategoriaDTO objDto) {

        Categoria newObj = service.update(idCategoria, objDto);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }

    @DeleteMapping(value = "/{idCategoria}")
    public ResponseEntity<Void> delete(@PathVariable Integer idCategoria) {
        service.delete(idCategoria);

        return ResponseEntity.noContent().build();
    }
}