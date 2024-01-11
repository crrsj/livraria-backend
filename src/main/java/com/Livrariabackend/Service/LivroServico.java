package com.Livrariabackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Livrariabackend.Dto.LivroDto;
import com.Livrariabackend.Erros.ObjectNotFoundException;
import com.Livrariabackend.Modelo.Categoria;
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
	public Livro create(Long id_cat, Livro obj) {
	obj.setId(null);
	Categoria cat = catService.findById(id_cat);
	obj.setCategoria(cat);
	return  repositorio.save(obj);
		
	}
	public void delete(Long id) {
		Livro obj = findById(id);
		repositorio.delete(obj);
		
	}
	
	
}
