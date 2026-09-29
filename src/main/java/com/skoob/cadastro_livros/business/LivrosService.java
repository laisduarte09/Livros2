package com.skoob.cadastro_livros.application.service;

import com.skoob.cadastro_livros.infrastructure.entitys.Livros;
import com.skoob.cadastro_livros.infrastructure.repository.LivrosRepository;
import org.springframework.stereotype.Service;

@Service
public class LivrosService {

    private final LivrosRepository repository;

    public LivrosService(LivrosRepository repository) {
        this.repository = repository;
    }

    public void salvarLivro(Livros livro) {
        repository.save(livro);
    }

    public Livros buscarLivroPorTitulo(String titulo) {
        return repository.findByTitulo(titulo)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public void atualizarLivroPorId(Integer id, Livros livro) {

        Livros livroEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Livros livroAtualizado = Livros.builder()
                .id(livroEntity.getId())
                .titulo(livro.getTitulo() != null
                        ? livro.getTitulo()
                        : livroEntity.getTitulo())
                .genero(livro.getGenero() != null
                        ? livro.getGenero()
                        : livroEntity.getGenero())
                .ano_publicacao(livro.getAno_publicacao() != null
                        ? livro.getAno_publicacao()
                        : livroEntity.getAno_publicacao())
                .build();

        repository.save(livroAtualizado);
    }

    public void deletarLivroPorTitulo(String titulo) {
        repository.deleteByTitulo(titulo);
    }
}