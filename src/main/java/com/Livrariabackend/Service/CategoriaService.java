package com.Livrariabackend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
