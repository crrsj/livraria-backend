package com.Livrariabackend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livrariabackend.Modelo.Livro;
@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

}
