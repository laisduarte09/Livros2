package com.skoob.cadastro_livros.controller;

import com.skoob.cadastro_livros.application.service.LivrosService;
import com.skoob.cadastro_livros.infrastructure.entitys.Livros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    private final LivrosService service;

    public LivrosController(LivrosService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Livros livro) {
        service.salvarLivro(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<Livros> buscarPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(service.buscarLivroPorTitulo(titulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPorId(
            @PathVariable Integer id,
            @RequestBody Livros livro) {

        service.atualizarLivroPorId(id, livro);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{titulo}")
    public ResponseEntity<Void> deletarPorTitulo(@PathVariable String titulo) {
        service.deletarLivroPorTitulo(titulo);
        return ResponseEntity.noContent().build();
    }
}