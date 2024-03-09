package com.mang.funtask.dominio.modelos;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
  @Column(name = "id_crianca")
  private UUID id;

  @Column(nullable = false)
  private String nome;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_crianca", referencedColumnName = "id")
  private Conta conta;

  private byte[] foto;

  @Column(nullable = false)
  private int pin;

  @Column(name = "mesada_base", nullable = false)
  private double mesadaBase;

  @Column(name = "id_responsavel", nullable = false)
  private UUID idResponsavel;

  public Crianca(CriancaDTO criancaDTO, UUID responsavel) {
    this.id = UUID.randomUUID();
    this.nome = criancaDTO.nome();
    this.conta = new Conta(this.id);
    this.foto = criancaDTO.foto();
    this.pin = Integer.parseInt(criancaDTO.pin());
    this.mesadaBase = criancaDTO.valorMesada();
    this.idResponsavel = responsavel;
  }
}
