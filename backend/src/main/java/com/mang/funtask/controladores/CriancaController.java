package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.AcessoPerfilDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.servicos.CriancaServico;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/crianca")
@RestController
@AllArgsConstructor
public class CriancaController {

  private final CriancaServico criancaServico;

  @PostMapping
  public ResponseEntity<String> autorizarAcesso(@RequestBody AcessoPerfilDTO dto) {
    Optional<Crianca> criancaOpt = criancaServico.encontrarCrianca(dto);

    if (criancaOpt.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Criança não encontrada.");
    }

    Crianca crianca = criancaOpt.get();
    if (!criancaServico.autorizarAcesso(crianca, dto.pin())) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("PIN incorreto.");
    }

    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
