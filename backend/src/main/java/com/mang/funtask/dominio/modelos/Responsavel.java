package com.mang.funtask.dominio.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
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

  public Responsavel(String senha, String nome, String pin) {
    this.nome = nome;
    this.senha = senha;
    this.pin = pin;
  }
}
