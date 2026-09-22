package com.skoob.cadastro_livros.infrastructure.entitys;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "livros")
@Entity

public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "titulo", unique = true)
    private String titulo;
    @Column(name = "autor", unique = true)
    private String autor;
    @Column(name = "genero", unique = true)
    private String genero;
    @Column(name = "ano_publicacao", unique = true)
    private String ano_publicacao;

}
