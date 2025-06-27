package com.styleme.projeto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TamanhoCalca", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"genero", "tamanho"})
})
public class TamanhoCalca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1)
    private String genero;

    @Column(nullable = false, length = 2)
    private String tamanho;

    @Column(nullable = false)
    private int cintura;

    @Column(nullable = false)
    private int quadril;

    @Column(nullable = false)
    private int perna;

}
