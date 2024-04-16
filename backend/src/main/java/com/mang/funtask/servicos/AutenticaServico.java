package com.mang.funtask.servicos;

import com.mang.funtask.dominio.modelos.Autenticavel;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import com.mang.funtask.repositorios.ResponsavelRepositorio;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutenticaServico implements UserDetailsService {

  private ResponsavelServico responsavelServico;
  private CriancaServico criancaServico;
  private ResponsavelRepositorio responsavelRepo;

  public Autenticavel encontrarPerfil(UUID id) {
    Optional<Responsavel> responsavel = responsavelServico.encontrarResponsavel(id);
    if (responsavel.isPresent()) {
      return responsavel.get();
    }

    Optional<Crianca> crianca = criancaServico.encontrarCrianca(id);
    if (crianca.isPresent()) {
      return crianca.get();
    }
    return null;
  }

  public boolean autorizarAcesso(Autenticavel perfil, int pin) {
    return perfil.getPin() == pin;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return responsavelRepo.findByEmail(username).get();
  }
}
