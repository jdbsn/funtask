package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import com.mang.funtask.repositorios.CriancaRepositorio;

import java.util.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriancaServico {

  private ResponsavelServico responsavelServico;
  private CriancaRepositorio criancaRepo;
  private ValidadorServico validadorServico;

  public Map<String, String> adicionarCrianca(CriancaDTO dto) {
    Map<String, String> mensagens = new HashMap<>();
    Optional<Responsavel> responsavel = responsavelServico.encontrarResponsavel(dto.idResponsavel());

    if(responsavel.isEmpty()) {
      mensagens.put("responsavel", "Responsável não encontrado.");
    }

    mensagens.putAll(validadorServico.validaCrianca(dto));

    if(!mensagens.isEmpty()) {
      return mensagens;
    }

    Crianca crianca = new Crianca(dto, responsavel.get());
    criancaRepo.save(crianca);

    return mensagens;
  }

  public Optional<Crianca> encontrarCrianca(UUID id) {
    return criancaRepo.findById(id);
  }

  public Optional<List<Crianca>> encontrarCriancaPorResponsavel(UUID idResponsavel) {
    return criancaRepo.encontrarPorIdResponsavel(idResponsavel);
  }

}
