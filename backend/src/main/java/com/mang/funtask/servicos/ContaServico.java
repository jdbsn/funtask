package com.mang.funtask.servicos;

import com.mang.funtask.dominio.modelos.Conta;
import com.mang.funtask.repositorios.ContaRepositorio;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ContaServico {

  private final ContaRepositorio contaRep;

  public ContaServico(ContaRepositorio contaRep) {
    this.contaRep = contaRep;
  }

  public Optional<Conta> encontrarContaPorIdCrianca(UUID idCrianca) {
    return contaRep.findByIdCrianca(idCrianca);
  }

  public void salvarConta(Conta conta) {
    contaRep.save(conta);
  }
}
