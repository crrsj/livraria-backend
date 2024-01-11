package com.Livrariabackend.Controle;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    @PostMapping
    public ResponseEntity<Categoria>create(@RequestBody Categoria obj){
    	obj = service.create(obj);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	return ResponseEntity.created(uri).build();
    }
}
