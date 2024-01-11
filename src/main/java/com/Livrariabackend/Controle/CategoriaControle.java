package com.Livrariabackend.Controle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Livrariabackend.Dto.CategoriaDto;
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
    @GetMapping
	public ResponseEntity<List<CategoriaDto>>findAll(){
		List<Categoria> list = service.findAll();
		List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}