package com.mang.funtask.dominio.dto.response;

import java.util.UUID;

public record PerfisDTO(UUID id, String nome, String foto, boolean responsavel) {

}
