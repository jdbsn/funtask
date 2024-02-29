package com.mang.funtask.dominio.dto;

import com.mang.funtask.dominio.enums.FREQUENCIA;
import com.mang.funtask.dominio.modelos.Atividade;
import com.mang.funtask.dominio.modelos.Crianca;

public record AtividadeDTO(Double valorCredito, Double valorDebito, FREQUENCIA frequencia,
                           Boolean foiConcluido, Crianca crianca) {

  public AtividadeDTO(Atividade atividade) {
    this(atividade.getValorCredito(), atividade.getValorDebito(), atividade.getFrequencia(),
        atividade.getFoiConcluido(), atividade.getCrianca());
  }

}
