package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.LoginDTO;
import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.dominio.dto.sistema.AutenticacaoDTO;
import com.mang.funtask.servicos.FunTaskServico;
import com.mang.funtask.servicos.ResponsavelServico;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/responsavel")
public class ResponsavelController {

  private static final UUID ID_RESPONSAVEL = UUID.fromString(
      "8fa13d0e-6905-455e-9001-a27ca60790f6");
  private final FunTaskServico funTaskServico;
  private final ResponsavelServico responsavelServico;

  @PostMapping("/login")
  public ResponseEntity<String> autenticarResponsavel(@RequestBody LoginDTO loginDTO) {
    AutenticacaoDTO resultadoAuth = responsavelServico.autenticarResponsavel(loginDTO);

    if(!resultadoAuth.status()){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultadoAuth.mensagem());
    }

    return ResponseEntity.status(HttpStatus.OK).body("Autorizado.");
  }

  @GetMapping("/listar-perfis")
  public ResponseEntity<List<PerfisDTO>> listarPerfis() {
    List<PerfisDTO> perfis = funTaskServico.encontrarPerfis(ID_RESPONSAVEL);

    if (perfis.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(perfis);
  }

}
