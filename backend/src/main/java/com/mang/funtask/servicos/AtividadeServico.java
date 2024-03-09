package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.AtividadeDTO;
import com.mang.funtask.dominio.dto.response.AtividadeResponseDTO;
import com.mang.funtask.dominio.modelos.Atividade;
import com.mang.funtask.repositorios.AtividadeRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AtividadeServico {

  private final AtividadeRepositorio atividadeRepositorio;

  public AtividadeServico(AtividadeRepositorio atividadeRepositorio) {
    this.atividadeRepositorio = atividadeRepositorio;
  }

  public List<AtividadeResponseDTO> listarAtividades() {
    List<Atividade> atividades = atividadeRepositorio.findAll();
    return atividades.stream().map(AtividadeResponseDTO::new).toList();
  }

  public Optional<Atividade> encontrarAtividadePorID(UUID id) {
    return atividadeRepositorio.findById(id);
  }

  public void salvarAtividade(AtividadeDTO atividadeDTO) {
    Atividade atividade = new Atividade(atividadeDTO);
    atividadeRepositorio.save(atividade);
  }

  public void editarAtividade(AtividadeResponseDTO atividadeResponseDTO) {
    Optional<Atividade> atividadeBanco = atividadeRepositorio.findById(atividadeResponseDTO.id());

    Atividade atividade = atividadeBanco.get();

    atividade.setTitulo(atividadeResponseDTO.titulo());
    atividade.setDescricao(atividadeResponseDTO.descricao());
    atividade.setValorCredito(atividadeResponseDTO.valorCredito());
    atividade.setValorDebito(atividadeResponseDTO.valorDebito());
    atividade.setFrequencia(atividadeResponseDTO.frequencia());

    atividadeRepositorio.save(atividade);
  }

  public void apagarAtividade(UUID id) {
    atividadeRepositorio.deleteById(id);
  }
}
