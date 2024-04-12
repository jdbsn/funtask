package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.LoginDTO;
import com.mang.funtask.dominio.dto.sistema.AutenticacaoDTO;
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

  public AutenticacaoDTO autenticarResponsavel(LoginDTO loginDTO) {
    Optional<Responsavel> optResponsavel = encontrarPorEmail(loginDTO.email());

    if(optResponsavel.isEmpty()) {
      return new AutenticacaoDTO("Email não encontrado.", false);
    }

    Responsavel responsavel = optResponsavel.get();

    if(!responsavel.getSenha().equals(loginDTO.senha())) {
      return new AutenticacaoDTO("Senha incorreta.", false);
    }

    return new AutenticacaoDTO("OK.", true);
  }

}
