package com.skoob.cadastro_livros.infrastructure.repository;

import com.skoob.cadastro_livros.infrastructure.entitys.Livros;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivrosRepository extends JpaRepository<Livros, Integer> {

    Optional<Livros> findByTitulo(String titulo);

    @Transactional
    void deleteByTitulo(String titulo);
}