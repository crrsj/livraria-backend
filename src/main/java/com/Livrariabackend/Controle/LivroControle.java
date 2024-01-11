package com.Livrariabackend.Controle;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Livrariabackend.Dto.LivroDto;
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

	 @GetMapping
	 public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "categoria",defaultValue = "0") Long id_cat){
			List<Livro> list = servico.findAll(id_cat);
			List<LivroDto> listDto = list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
			//localhots:88/livros?categoria=1
    }
	 

	   @PutMapping(value  = "/{id}")
	    public ResponseEntity<Livro>update(@PathVariable Long id,@RequestBody Livro obj){
		var newObj = servico.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	   

	   @PatchMapping(value  = "/{id}")
	    public ResponseEntity<Livro>updatePatch(@PathVariable Long id,@RequestBody Livro obj){
		var newObj = servico.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	   @PostMapping
	   public ResponseEntity<Livro>create(@RequestParam(value = "categoria",defaultValue = "0") Long id_cat, @RequestBody Livro obj){
		   Livro newObj = servico.create(id_cat,obj);
		  URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		  return ResponseEntity.created(uri).build();
	   }
	   
	   @DeleteMapping(value = "/{id}")
	   public ResponseEntity<Void>delete(@PathVariable Long id){
		   servico.delete(id);
		   return ResponseEntity.noContent().build();
	   }
}
 
	 
	 
