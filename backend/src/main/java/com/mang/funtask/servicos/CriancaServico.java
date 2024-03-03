package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import com.mang.funtask.repositorios.CriancaRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriancaServico {

  private ResponsavelServico responsavelServico;
  private CriancaRepositorio criancaRepo;

  public boolean adicionarCrianca(CriancaDTO dto) {
    Optional<Responsavel> responsavel = responsavelServico.encontrarResponsavel(dto.idResponsavel());

    if(responsavel.isEmpty()) {
      return false;
    }

    Crianca crianca = new Crianca(dto, responsavel.get());
    criancaRepo.save(crianca);

    return true;
  }

  public Optional<Crianca> encontrarCrianca(UUID id) {
    return criancaRepo.findById(id);
  }

  public Optional<List<Crianca>> encontrarCriancaPorResponsavel(UUID idResponsavel) {
    return criancaRepo.encontrarPorIdResponsavel(idResponsavel);
  }

}
