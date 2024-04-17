package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.servicos.FunTaskServico;
import com.mang.funtask.servicos.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/responsavel")
public class ResponsavelController {

  private final FunTaskServico funTaskServico;
  private final TokenService tokenService;

  @GetMapping("/listar-perfis")
  public ResponseEntity<List<PerfisDTO>> listarPerfis(HttpServletRequest request) {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();

    List<PerfisDTO> perfis = funTaskServico.encontrarPerfis(email);

    if (perfis.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(perfis);
  }

}
