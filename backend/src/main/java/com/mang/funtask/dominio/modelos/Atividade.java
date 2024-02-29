package com.mang.funtask.dominio.modelos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_atividade")
    private UUID id;

}
