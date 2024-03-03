package com.mang.funtask.dominio.modelos;

import com.mang.funtask.dominio.dto.request.TransacaoDTO;
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

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_transacao", nullable = false)
  private TipoTransacao tipoTransacao;

  @Column(name = "id_atividade")
  private UUID idAtividade;

  public Transacao(TransacaoDTO transacaoDTO, UUID atividade) {
    this.tipoTransacao = transacaoDTO.tipoTransacao();
    this.idAtividade = atividade;
  }

  public Transacao(TipoTransacao tipoTransacao, UUID idAtividade) {
    this.tipoTransacao = tipoTransacao;
    this.idAtividade = idAtividade;
  }
}
