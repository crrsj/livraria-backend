package com.Livrariabackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Livrariabackend.Dto.LivroDto;
import com.Livrariabackend.Erros.ObjectNotFoundException;
import com.Livrariabackend.Modelo.Livro;
import com.Livrariabackend.Repositorio.LivroRepositorio;

@Service
public class LivroServico {

	@Autowired
	private LivroRepositorio repositorio;
	@Autowired
	private CategoriaService catService;
	
	public Livro findById(Long id) {
		Optional<Livro> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(" livro não encontrado ! " + id + " , tipo: " + Livro.class.getName()));
	}
	public List<Livro>findAll(Long id_cat){
		catService.findById(id_cat);
		return repositorio.findAllByCategoria(id_cat);
	}
	
	public Livro update(Long id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj,obj);
		return repositorio.save(newObj);
	}
	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNomeAutor(obj.getNomeAutor());
		newObj.setTexto(obj.getTexto());
		
	}
	
	
}
