package com.Livrariabackend.Controle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
	 
}	 
	 
	 
