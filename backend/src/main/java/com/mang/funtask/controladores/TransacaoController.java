package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.TransacaoDTO;
import com.mang.funtask.servicos.TransacaoServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/responsavel/transacao")
public class TransacaoController {

  private final TransacaoServico transacaoServico;

  public TransacaoController(TransacaoServico transacaoServico) {
    this.transacaoServico = transacaoServico;
  }

  @PostMapping
  public ResponseEntity<String> fazerTransacao(@RequestBody TransacaoDTO transacaoDTO) {
    String resposta = transacaoServico.atualizarMesadaPorAtividade(transacaoDTO);

    if (!resposta.isEmpty()) {
      return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
