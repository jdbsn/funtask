package com.mang.funtask.dominio.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record CriancaDTO(@NotEmpty(message = "Nome inválido.")
                         String nome,
                         byte[] foto,
                         @Pattern(regexp = "^(?!0000)\\d{4}$", message = "Informe um pin com 4 dígitos.")
                         String pin,
                         UUID idResponsavel) {
}
