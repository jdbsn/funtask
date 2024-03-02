package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.AtividadeDTO;
import com.mang.funtask.servicos.AtividadeServico;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/atividades")
public class AtividadeController {

  private final AtividadeServico atividadeServico;

  public AtividadeController(AtividadeServico atividadeServico) {
    this.atividadeServico = atividadeServico;
  }

  @PostMapping("/responsavel")
  public void criarAtividade(@RequestBody AtividadeDTO atividadeDTO) {
    this.atividadeServico.salvarAtividade(atividadeDTO);
  }

  @GetMapping
  public List<AtividadeDTO> listarAtividades() {
    return atividadeServico.listarAtividades();
  }

}
