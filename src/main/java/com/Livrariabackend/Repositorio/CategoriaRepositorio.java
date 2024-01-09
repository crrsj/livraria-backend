package com.Livrariabackend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livrariabackend.Modelo.Categoria;
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
