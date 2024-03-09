package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.TransacaoAtividadeDTO;
import com.mang.funtask.servicos.TransacaoServico;
import java.util.Optional;
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

  @PostMapping("/atividade")
  public ResponseEntity<String> fazerTransacaoAtividade(@RequestBody TransacaoAtividadeDTO transacaoDTO) {
    Optional<String > resposta = transacaoServico.atividadeTransacao(transacaoDTO);

    if (resposta.isPresent()) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposta.get());
    }

    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
