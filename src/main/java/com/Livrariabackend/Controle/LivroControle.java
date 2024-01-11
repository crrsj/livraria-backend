package com.Livrariabackend.Controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Livrariabackend.Modelo.Livro;
import com.Livrariabackend.Service.LivroServico;


@RestController
@RequestMapping(value = "/livros")
public class LivroControle {
	
	@Autowired
	private LivroServico servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro>FindById(@PathVariable Long id){
		var obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
