package com.Livrariabackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Livrariabackend.Dto.CategoriaDto;
import com.Livrariabackend.Erros.ObjectNotFoundException;
import com.Livrariabackend.Modelo.Categoria;
import com.Livrariabackend.Repositorio.CategoriaRepositorio;

@Service
public class CategoriaService {
	
	@Autowired
    private	CategoriaRepositorio repositorio;

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria de livro não encontrada ! " + id + " , tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria>findAll(){
		return repositorio.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repositorio.save(obj);
	}

	public Categoria update(Long id, CategoriaDto objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repositorio.deleteById(id);
		
	}
}
