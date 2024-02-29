package com.mang.funtask.dominio.dto;

import com.mang.funtask.dominio.enums.FREQUENCIA;

public record AtividadeDTO(Double valorCredito, Double valorDebito, FREQUENCIA frequencia,
                           Boolean foiConcluido) {

}
