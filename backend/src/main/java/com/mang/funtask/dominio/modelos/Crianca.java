package com.mang.funtask.dominio.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crianca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_crianca")
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private byte[] foto;

    @Column(nullable = false)
    private int pin;

    @Column(nullable = false)
    private double saldo;

    @ManyToOne
    private Responsavel responsavel;

}
