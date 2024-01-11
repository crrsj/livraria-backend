package com.Livrariabackend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Livrariabackend.Erros.ObjectNotFoundException;

import com.Livrariabackend.Modelo.Livro;
import com.Livrariabackend.Repositorio.LivroRepositorio;

@Service
public class LivroServico {

	@Autowired
	private LivroRepositorio repositorio;
	
	public Livro findById(Long id) {
		Optional<Livro> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(" livro não encontrado ! " + id + " , tipo: " + Livro.class.getName()));
	}
	
	
}
