package com.Livrariabackend.Dto;

import com.Livrariabackend.Modelo.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class CategoriaDto {
	
	private Long id;
	private String nome;
	private String descricao;
	public CategoriaDto(Categoria obj) {		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
	
	

}
