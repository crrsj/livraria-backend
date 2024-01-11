package com.Livrariabackend.Dto;


import com.Livrariabackend.Modelo.Livro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LivroDto {
	
	private Long id;
	private String titulo;
	public LivroDto(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	
}
