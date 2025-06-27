package com.styleme.projeto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "Avatar")
@Data
@AllArgsConstructor
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_avatar")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    private Cliente cliente;

    private int torax;
    private int torso;
    private int braco;
    private int cintura;
    private int quadril;
    private int perna;

}