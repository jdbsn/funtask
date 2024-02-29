package com.mang.funtask.dominio.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_responsavel")
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String pin;

    public Responsavel() {

    }

}
