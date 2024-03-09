package com.mang.funtask.dominio.dto.request;

import com.mang.funtask.dominio.enums.Frequencia;
import com.mang.funtask.dominio.modelos.Atividade;
import java.util.UUID;

public record AtividadeDTO(String titulo, String descricao, Double valorCredito, Double valorDebito,
                           Frequencia frequencia, UUID idResponsavel) {

  public AtividadeDTO(Atividade atividade) {
    this(atividade.getTitulo(), atividade.getDescricao(), atividade.getValorCredito(), atividade.getValorDebito(), atividade.getFrequencia(), atividade.getIdResponsavel());
  }
}
