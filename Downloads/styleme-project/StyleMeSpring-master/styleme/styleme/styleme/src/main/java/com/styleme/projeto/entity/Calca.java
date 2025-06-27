package com.styleme.projeto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "Calca")
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Calca extends Roupa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_calça")
    private UUID id;

    @Column(nullable = false)
    private String tamanho;

    @Column(nullable = false)
    private int cintura;

    @Column(nullable = false)
    private int quadril;

    @Column(nullable = false)
    private int perna;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_roupa", nullable = false,insertable=false, updatable=false)
    private Roupa roupaRelacionada;


    @Override
    public void mostrarDetalhes() {
        System.out.println("Camisa: " + nome + ", Tamanho: " + tamanho + ", Cintura: " + cintura + "cm, Quadril: " + quadril + "cm, Perna: " + perna + "cm");
    }
}