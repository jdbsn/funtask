package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.servicos.CriancaServico;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crianca")
@AllArgsConstructor
public class CriancaController {

  private CriancaServico criancaServico;

  @PostMapping
  public ResponseEntity<Map<String, String>> adicionarCrianca(@RequestBody CriancaDTO crianca) {
    Map<String, String> mensagens = criancaServico.adicionarCrianca(crianca);

    if (!mensagens.isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagens);
    }

    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
