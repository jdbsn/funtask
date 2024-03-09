package com.mang.funtask.dominio.modelos;

import com.mang.funtask.dominio.enums.TipoTransacao;
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
public class Transacao {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_transacao")
  private UUID id;

  @Column(name = "descricao_transacao")
  private String descricao;

  @Column(name = "valor_transacao", nullable = false)
  private double valorTransacao;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_transacao", nullable = false)
  private TipoTransacao tipoTransacao;

  @Column(nullable = false)
  private double saldoAnterior;

  @Column(nullable = false)
  private double saldoAtual;

  @Column(name = "nome_crianca", nullable = false)
  private String nomeCrianca;

  public Transacao(Crianca crianca, Atividade atividade, TipoTransacao tipoTransacao, double valorTransacao, Conta conta) {
    this.descricao = "Atividade: " + atividade.getTitulo() +
                      ((tipoTransacao == TipoTransacao.CREDITO) ? " realizada." : " não realizada.");
    this.tipoTransacao = tipoTransacao;
    this.valorTransacao = valorTransacao;
    this.saldoAnterior = conta.getSaldo();
    this.saldoAtual = saldoAnterior + valorTransacao;
    this.nomeCrianca = crianca.getNome();
  }
}
