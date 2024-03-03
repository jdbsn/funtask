package com.mang.funtask.dominio.dto.request;

import com.mang.funtask.dominio.enums.TipoTransacao;
import java.util.UUID;

public record TransacaoDTO(TipoTransacao tipoTransacao, UUID idAtividade) {

}
