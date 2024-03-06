package com.mang.funtask.dominio.dto.response;

import com.mang.funtask.dominio.enums.Frequencia;
import com.mang.funtask.dominio.modelos.Atividade;
import java.util.UUID;

public record AtividadeResponseDTO(UUID id, String descricao, Double valorCredito, Double valorDebito,
                                   Frequencia frequencia, UUID idCrianca, String nomeCrianca, byte[] fotoCrianca) {

}
