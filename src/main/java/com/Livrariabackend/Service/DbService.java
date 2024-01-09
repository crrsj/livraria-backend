package com.Livrariabackend.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Livrariabackend.Modelo.Categoria;
import com.Livrariabackend.Modelo.Livro;
import com.Livrariabackend.Repositorio.CategoriaRepositorio;
import com.Livrariabackend.Repositorio.LivroRepositorio;


@Service
public class DbService {
	
	
	@Autowired
	private CategoriaRepositorio catrep;
	@Autowired
	private LivroRepositorio lrep;
    
	public void instanciaBaseDeDados() {
		Categoria c1  = new Categoria(null,"POO","Livro de ti");
		Livro l1 = new Livro(null,"Java","Deitel","Lorem ipsun",c1);
		c1.getLivros().addAll(Arrays.asList(l1));
		
		this.catrep.saveAll(Arrays.asList(c1));
		this.lrep.saveAll(Arrays.asList(l1));
	}

}
