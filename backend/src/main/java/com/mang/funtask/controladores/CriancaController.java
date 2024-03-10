package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.dominio.dto.response.PerfilCriancaDTO;
import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.servicos.CriancaServico;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/crianca")
@AllArgsConstructor
public class CriancaController {

  private static final UUID ID_RESPONSAVEL = UUID.fromString("8fa13d0e-6905-455e-9001-a27ca60790f6");
  private CriancaServico criancaServico;

  @GetMapping
  public ResponseEntity<List<PerfisDTO>> listarCriancas() {
    List<PerfisDTO> criancas = criancaServico.listarCriancasPorResponsavel(ID_RESPONSAVEL);

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
