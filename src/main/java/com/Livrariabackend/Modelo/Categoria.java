package com.Livrariabackend.Modelo;



import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import lombok.Setter;



@Getter
@Setter
@Entity
public class Categoria implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotEmpty(message = "Campo Nome é obrigatório")
	@Length(min = 3,max = 100,message = "O campo Nome deve ter entre 3 e 100 caracteres")
    private String nome;
	@NotEmpty(message = "Campo Descrição é obrigatório")
	@Length(min = 3,max = 200,message = "O campo Descrição deve ter entre 3 e 100 caracteres")
    private String descricao;
    @OneToMany(mappedBy = "categoria")
    private List<Livro>livros = new ArrayList<>();
	public Categoria(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	public Categoria() {
		super();
	}
	
 

 
}
