package com.mang.funtask.dominio.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Conta {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_conta")
  private UUID id;

  @Column(nullable = false)
  private double saldo;

  @Column(name = "id_crianca", nullable = false)
  private UUID idCrianca;

  public Conta(UUID idCrianca) {
    this.saldo = 0.0;
    this.idCrianca = idCrianca;
  }

}
