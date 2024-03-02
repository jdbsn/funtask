package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.AtividadeDTO;
import com.mang.funtask.dominio.modelos.Atividade;
import com.mang.funtask.repositorios.AtividadeRepositorio;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AtividadeServico {

  private final AtividadeRepositorio atividadeRepositorio;

  public AtividadeServico(AtividadeRepositorio atividadeRepositorio) {
    this.atividadeRepositorio = atividadeRepositorio;
  }

  public List<AtividadeDTO> listarAtividades() {
    List<Atividade> atividades = atividadeRepositorio.findAll();

    return atividades.stream()
        .map(AtividadeDTO::new)
        .toList();
  }

  public void salvarAtividade(AtividadeDTO atividadeDTO) {
    Atividade atividade = new Atividade(atividadeDTO);
    atividadeRepositorio.save(atividade);
  }
}
