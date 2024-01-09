package com.Livrariabackend.Modelo;



import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	private String titulo;
	private String nomeAutor;
	private String texto;
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
