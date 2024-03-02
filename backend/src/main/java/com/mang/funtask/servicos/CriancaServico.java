package com.mang.funtask.servicos;

import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.repositorios.CriancaRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriancaServico {

  private CriancaRepositorio criancaRepo;

  public Optional<Crianca> encontrarCrianca(UUID id) {
    return criancaRepo.findById(id);
  }

  public Optional<List<Crianca>> encontrarCriancaPorResponsavel(UUID idResponsavel) {
    return criancaRepo.encontrarPorIdResponsavel(idResponsavel);
  }

}
