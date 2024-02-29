package com.mang.funtask.dominio.modelos;

import com.mang.funtask.dominio.dto.AtividadeDTO;
import com.mang.funtask.dominio.enums.FREQUENCIA;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import lombok.Getter;

@Entity
@Getter
public class Atividade {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_atividade")
  private UUID id;

  @Column(name = "valor_credito", nullable = false)
  private Double valorCredito;

  @Column(name = "valor_debito", nullable = false)
  private Double valorDebito;

  @Column(nullable = false)
  private FREQUENCIA frequencia;

  @Column(name = "foi_concluido", nullable = false)
  private Boolean foiConcluido;

  @OneToOne
  @JoinColumn(name="id_responsavel", referencedColumnName = "id_responsavel")
  private Responsavel responsavel;

  @ManyToOne
  @JoinColumn(name = "id_crianca", referencedColumnName = "id_crianca")
  private Crianca crianca;

  public Atividade() {

  }

  public Atividade(Double valorCredito, Double valorDebito, FREQUENCIA frequencia,
      Boolean foiConcluido, Crianca crianca) {
    this.valorCredito = valorCredito;
    this.valorDebito = valorDebito;
    this.frequencia = frequencia;
    this.foiConcluido = foiConcluido;
    this.crianca = crianca;
  }

  public Atividade(AtividadeDTO atividadeDTO) {
    this.valorCredito = atividadeDTO.valorCredito();
    this.valorDebito = atividadeDTO.valorDebito();
    this.frequencia = atividadeDTO.frequencia();
    this.foiConcluido = atividadeDTO.foiConcluido();
    this.crianca = atividadeDTO.crianca();
  }
}
