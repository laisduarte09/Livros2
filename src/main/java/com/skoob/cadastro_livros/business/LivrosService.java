package com.skoob.cadastro_livros.business;

import com.skoob.cadastro_livros.infrastructure.entitys.Livros;
import com.skoob.cadastro_livros.infrastructure.repository.LivrosRepository;
import org.springframework.stereotype.Service;

@Service
public class LivrosService {

    private final LivrosRepository repository;

    public LivrosService(LivrosRepository repository) {
        this.repository = repository;
    }

    public void salvarLivro(Livros livro){
        repository.saveAndFlush(livro);
    }
    public Livros buscarLivrosPorTitulo{String titulo}
}
