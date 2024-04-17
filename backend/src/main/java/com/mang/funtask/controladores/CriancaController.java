package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.dominio.dto.response.PerfilCriancaDTO;
import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.servicos.CriancaServico;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/crianca")
@AllArgsConstructor
public class CriancaController {

  private CriancaServico criancaServico;

  @GetMapping
  public ResponseEntity<List<PerfisDTO>> listarCriancas() {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();

    List<PerfisDTO> criancas = criancaServico.listarCriancasPorResponsavel(email);

    if(criancas.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(criancas);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<PerfilCriancaDTO> encontrarCrianca(@PathVariable("id") UUID id) {
    PerfilCriancaDTO crianca = criancaServico.encontrarPerfilCrianca(id);

    if(crianca == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(crianca);
  }

  @PostMapping
  public ResponseEntity<Map<String, String>> adicionarCrianca(@RequestBody CriancaDTO crianca) {
    Map<String, String> mensagens = criancaServico.adicionarCrianca(crianca);

    if (!mensagens.isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagens);
    }

    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
