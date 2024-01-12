package com.Livrariabackend.Dto;

import org.hibernate.validator.constraints.Length;

import com.Livrariabackend.Modelo.Categoria;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class CategoriaDto {
	
	private Long id;
	@NotEmpty(message = "Campo Nome é obrigatório")
	@Length(min = 3,max = 100,message = "O campo Nome deve ter entre 3 e 100 caracteres")
	private String nome;
	@NotEmpty(message = "Campo Descrição é obrigatório")
	@Length(min = 3,max = 200,message = "O campo Descrição deve ter entre 3 e 100 caracteres")
	private String descricao;
	public CategoriaDto(Categoria obj) {		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
	
	

}
