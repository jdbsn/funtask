package com.mang.funtask.dominio.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;

public record CriancaDTO(@NotEmpty(message = "Informe um nome válido.")
                         String nome,
                         byte[] foto,
                         @NotEmpty(message = "Informe uma PIN válido.")
                         @Pattern(regexp = "^(?!0000)\\d{4}$", message = "Informe um pin com 4 dígitos.")
                         String pin,
                         @NotNull(message = "Informe uma mesada válida.")
                         @Min(value = 0, message = "Informe uma mesada válida.")
                         double valorMesada,
                         UUID idResponsavel) {

}
