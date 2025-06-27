package com.styleme.projeto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TamanhoCamisa", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"genero", "tamanho"})
})
public class TamanhoCamisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1)
    private String genero;

    @Column(nullable = false, length = 2)
    private String tamanho;

    @Column(nullable = false)
    private int comprimento;

    @Column(nullable = false)
    private int largura;

    @Column(nullable = false)
    private int manga;

}
