package com.mang.funtask.dominio.dto.request;

import com.mang.funtask.dominio.enums.Frequencia;
import com.mang.funtask.dominio.modelos.Atividade;
import java.util.UUID;

public record AtividadeDTO(String descricao, Double valorCredito, Double valorDebito,
                           Frequencia frequencia, UUID idCrianca) {

  public AtividadeDTO(Atividade atividade) {
    this(atividade.getDescricao(), atividade.getValorCredito(), atividade.getValorDebito(),
        atividade.getFrequencia(), atividade.getIdCrianca());
  }
}
