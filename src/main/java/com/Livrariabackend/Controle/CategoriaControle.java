package com.Livrariabackend.Controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Livrariabackend.Modelo.Categoria;
import com.Livrariabackend.Service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaControle {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria>FindById(@PathVariable Long id){
		var obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
