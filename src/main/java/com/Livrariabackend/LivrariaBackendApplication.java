package com.Livrariabackend;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Livrariabackend.Modelo.Categoria;
import com.Livrariabackend.Modelo.Livro;
import com.Livrariabackend.Repositorio.CategoriaRepositorio;
import com.Livrariabackend.Repositorio.LivroRepositorio;

@SpringBootApplication
public class LivrariaBackendApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepositorio catrep;
	@Autowired
	private LivroRepositorio lrep;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1  = new Categoria(null,"POO","Livro de ti");
		Livro l1 = new Livro(null,"Java","Deitel","Lorem ipsun",c1);
		c1.getLivros().addAll(Arrays.asList(l1));
		
		this.catrep.saveAll(Arrays.asList(c1));
		this.lrep.saveAll(Arrays.asList(l1));
	}

}
