package com.Livrariabackend.Modelo;



import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@Entity
public class Livro implements Serializable {
 
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Campo Titulo é obrigatório")
	@Length(min = 3,max = 50,message = "O campo Titulo deve ter entre 3 e 50 caracteres")
	private String titulo;
	@NotEmpty(message = "Campo Autor é obrigatório")
	@Length(min = 3,max = 50,message = "O campo Autor deve ter entre 3 e 50 caracteres")
	private String nomeAutor;
	@NotEmpty(message = "Campo Texto é obrigatório")
	@Length(min = 3,max = 2000000,message = "O campo texto deve ter entre 3 e 2000000 caracteres")
	private String texto;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria  categoria;
	public Livro(Long id, String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}
	public Livro() {
		super();
	}
	
	
	
}
