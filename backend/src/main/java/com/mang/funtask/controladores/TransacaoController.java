package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.TransacaoAtividadeDTO;
import com.mang.funtask.dominio.modelos.Transacao;
import com.mang.funtask.servicos.TransacaoServico;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/responsavel/transacao")
public class TransacaoController {

  private final TransacaoServico transacaoServico;

  @GetMapping("/{id}")
  public ResponseEntity<List<Transacao>> listarTransacoes(@PathVariable("id") UUID id) {
    List<Transacao> transacoes = transacaoServico.listarTransacoesCrianca(id);

    if(transacoes.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(transacoes);
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
