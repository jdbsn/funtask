package com.mang.funtask.dominio.dto.response;

import com.mang.funtask.dominio.enums.Frequencia;
import com.mang.funtask.dominio.modelos.Atividade;
import java.util.UUID;

public record AtividadeResponseDTO(UUID id, String titulo, String descricao, Double valorCredito, Double valorDebito,
                                   Frequencia frequencia) {
    public AtividadeResponseDTO(Atividade atividade) {
    this(
        atividade.getId(),
        atividade.getTitulo(),
        atividade.getDescricao(),
        atividade.getValorCredito(),
        atividade.getValorDebito(),
        atividade.getFrequencia());
    }
}
