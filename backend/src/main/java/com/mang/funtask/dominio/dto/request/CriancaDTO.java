package com.mang.funtask.dominio.dto.request;

import java.util.UUID;

public record CriancaDTO(String nome, byte[] foto, int pin, UUID idResponsavel) {
}
