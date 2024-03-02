package com.mang.funtask.dominio.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crianca implements Autenticavel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_crianca")
  private UUID id;

  @Column(nullable = false)
  private String nome;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_conta", referencedColumnName = "id_conta")
  private Conta conta;

  private byte[] foto;

  @Column(nullable = false)
  private int pin;

  @ManyToOne
  @JoinColumn(name = "id_responsavel", nullable = false)
  private Responsavel responsavel;

  @JsonIgnore
  @OneToMany(mappedBy = "crianca")
  private Set<Atividade> atividades;
}
