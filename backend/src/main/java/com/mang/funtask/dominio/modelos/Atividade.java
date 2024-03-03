package com.mang.funtask.dominio.modelos;

import com.mang.funtask.dominio.dto.request.AtividadeDTO;
import com.mang.funtask.dominio.enums.Frequencia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atividade {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_atividade")
  private UUID id;

  private String descricao;

  @Column(name = "valor_credito", nullable = false)
  private double valorCredito;

  @Column(name = "valor_debito", nullable = false)
  private double valorDebito;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Frequencia frequencia;

  @Column(name = "id_crianca", nullable = false)
  private UUID idCrianca;

  public Atividade(AtividadeDTO atividadeDTO) {
    this.descricao = atividadeDTO.descricao();
    this.valorCredito = atividadeDTO.valorCredito();
    this.valorDebito = atividadeDTO.valorDebito();
    this.frequencia = atividadeDTO.frequencia();
    this.idCrianca = atividadeDTO.idCrianca();
  }
}
