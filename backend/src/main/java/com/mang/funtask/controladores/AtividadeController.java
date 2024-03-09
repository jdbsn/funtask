package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.AtividadeDTO;
import com.mang.funtask.dominio.dto.response.AtividadeResponseDTO;
import com.mang.funtask.servicos.AtividadeServico;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/atividades")
public class AtividadeController {

  private static final UUID ID_RESPONSAVEL = UUID.fromString(
      "8fa13d0e-6905-455e-9001-a27ca60790f6");
  private final AtividadeServico atividadeServico;

  public AtividadeController(AtividadeServico atividadeServico) {
    this.atividadeServico = atividadeServico;
  }

  @PostMapping("/responsavel")
  public void criarAtividade(@RequestBody AtividadeDTO atividadeDTO) {
    this.atividadeServico.salvarAtividade(atividadeDTO);
  }

  @GetMapping
  public List<AtividadeResponseDTO> listarAtividades() {
    return atividadeServico.listarAtividades(ID_RESPONSAVEL);
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
