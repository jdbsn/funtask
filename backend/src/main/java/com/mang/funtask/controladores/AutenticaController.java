package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.AcessoPerfilDTO;
import com.mang.funtask.dominio.modelos.Autenticavel;
import com.mang.funtask.servicos.AutenticaServico;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticarPin")
@AllArgsConstructor
public class AutenticaController {

  private AutenticaServico autenticaServico;

  @PostMapping
  public ResponseEntity<String> autenticar(@RequestBody AcessoPerfilDTO dto) {
    Autenticavel perfil = autenticaServico.encontrarPerfil(dto.id());

    if (perfil == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Perfil não encontrado.");
    }

    if (!autenticaServico.autorizarAcesso(perfil, dto.pin())) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("PIN incorreto.");
    }

    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
