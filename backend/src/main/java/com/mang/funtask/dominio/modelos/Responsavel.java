package com.mang.funtask.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_responsavel")
    private UUID id;

}
