package com.samuel.bookstore;

import java.util.Arrays;

import com.samuel.bookstore.domain.Categoria;
import com.samuel.bookstore.domain.Livro;
import com.samuel.bookstore.repositories.CategoriaRepository;
import com.samuel.bookstore.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria = new Categoria(null, "informatica", "livros de ti");
		Livro livro = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", categoria);
		categoria.getLivros().addAll(Arrays.asList(livro));

		this.categoriaRepository.saveAll(Arrays.asList(categoria));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}

}
