package com.mang.funtask.dominio.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsavel implements Autenticavel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_responsavel")
  private UUID id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String senha;

  @Column(nullable = false)
  private int pin;

  @OneToMany(mappedBy = "idResponsavel", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Crianca> criancas;
}
