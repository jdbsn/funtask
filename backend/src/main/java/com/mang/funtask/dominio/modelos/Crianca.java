package com.mang.funtask.dominio.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Crianca {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_crianca")
  private UUID id;
}
