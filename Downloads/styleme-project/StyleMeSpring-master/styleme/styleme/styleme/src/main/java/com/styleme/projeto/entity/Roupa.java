package com.styleme.projeto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Roupa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_roupa")
    private UUID id;

    protected char genero;
    protected String nome;
    protected double valor;
    protected int quantidade;

    @OneToMany(mappedBy = "roupaRelacionada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Camisa> camisas;

    @OneToMany(mappedBy = "roupaRelacionada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calca> calcas;

    public abstract void mostrarDetalhes();
}