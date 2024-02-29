package com.mang.funtask.dominio.dto;

import com.mang.funtask.dominio.enums.Frequencia;
import com.mang.funtask.dominio.modelos.Atividade;
import com.mang.funtask.dominio.modelos.Crianca;

public record AtividadeDTO(String descricao, Double valorCredito, Double valorDebito,
                           Frequencia frequencia, Crianca crianca) {

  public AtividadeDTO(Atividade atividade) {
    this(atividade.getDescricao(), atividade.getValorCredito(), atividade.getValorDebito(),
        atividade.getFrequencia(), atividade.getCrianca());
  }

}
