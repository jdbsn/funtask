package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.AtividadeDTO;
import com.mang.funtask.dominio.dto.response.AtividadeResponseDTO;
import com.mang.funtask.servicos.AtividadeServico;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/atividades")
@AllArgsConstructor
public class AtividadeController {

  private final AtividadeServico atividadeServico;

  @GetMapping
  public ResponseEntity<List<AtividadeResponseDTO>> listarAtividades() {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();

    List<AtividadeResponseDTO> atividades = atividadeServico.listarAtividades(email);

    return ResponseEntity.status(HttpStatus.OK).body(atividades);
  }

  @PostMapping()
  public void criarAtividade(@RequestBody AtividadeDTO atividadeDTO) {
    this.atividadeServico.salvarAtividade(atividadeDTO);
  }

  @PutMapping
  public void editarAtividade(@RequestBody AtividadeResponseDTO atividadeResponseDTO) {
    atividadeServico.editarAtividade(atividadeResponseDTO);
  }

  @DeleteMapping("/{id}")
  public void apagarAtividade(@PathVariable("id") UUID id) {
    atividadeServico.apagarAtividade(id);
  }

}
