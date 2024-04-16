package com.mang.funtask.servicos;

import com.mang.funtask.dominio.modelos.Responsavel;
import com.mang.funtask.repositorios.ResponsavelRepositorio;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResponsavelServico {

  private ResponsavelRepositorio responsavelRepo;

  public Optional<Responsavel> encontrarPorEmail(String email) {
    return responsavelRepo.findByEmail(email);
  }

  public Optional<Responsavel> encontrarResponsavel(UUID id) {
    return responsavelRepo.findById(id);
  }

}
