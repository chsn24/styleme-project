package com.styleme.projeto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "Camisa")
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Camisa extends Roupa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_camisa")
    private UUID id;

    @Column(nullable = false)
    private String tamanho;

    @Column(nullable = false)
    private int torso;

    @Column(nullable = false)
    private int torax;

    @Column(nullable = false)
    private int braco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_roupa", nullable = false,insertable=false, updatable=false)
    private Roupa roupaRelacionada;

    @Override
    public void mostrarDetalhes() {
        System.out.println("Calça: " + nome + ", Tamanho: " + tamanho + ", Torso: " + torso + "cm, Tórax: " + torax + "cm, Braço: " + braco + "cm");
    }
}
