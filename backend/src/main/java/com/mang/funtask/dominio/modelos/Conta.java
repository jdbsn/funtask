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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_conta")
  private UUID id;

  @Column(nullable = false)
  private Double saldo;

  @OneToOne(mappedBy = "conta")
  private Crianca crianca;
}
