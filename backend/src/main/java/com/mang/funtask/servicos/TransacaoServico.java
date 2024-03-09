package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.TransacaoAtividadeDTO;
import com.mang.funtask.dominio.enums.TipoTransacao;
import com.mang.funtask.dominio.modelos.Atividade;
import com.mang.funtask.dominio.modelos.Conta;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Transacao;
import com.mang.funtask.repositorios.ContaRepositorio;
import com.mang.funtask.repositorios.TransacaoRepositorio;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServico {

  private final TransacaoRepositorio transacaoRepo;
  private final ContaRepositorio contaRepo;
  private final CriancaServico criancaServico;
  private final AtividadeServico atividadeServico;

  public TransacaoServico(TransacaoRepositorio transacaoRepo, ContaRepositorio contaRepo, AtividadeServico atividadeServico,
                          CriancaServico criancaServico, AtividadeServico atividadeServico1) {
    this.transacaoRepo = transacaoRepo;
    this.contaRepo = contaRepo;
    this.criancaServico = criancaServico;
    this.atividadeServico = atividadeServico1;
  }

  public Optional<String> atividadeTransacao(TransacaoAtividadeDTO transacaoDTO) {
    Optional<Crianca> encontrarCrianca = this.criancaServico.encontrarCrianca(transacaoDTO.idCrianca());
    Optional<Atividade> encontrarAtidade = this.atividadeServico.encontrarAtividadePorID(transacaoDTO.idAtividade());

    if (encontrarCrianca.isEmpty()) {
      return Optional.of("Nenhuma criança encontrada.");
    }
    if (encontrarAtidade.isEmpty()) {
      return Optional.of("Nenhuma atividade encontrada.");
    }

    Crianca crianca = encontrarCrianca.get();
    Atividade atividade = encontrarAtidade.get();
    realizarTransacao(crianca, atividade, transacaoDTO.tipoTransacao());

    return Optional.empty();
  }

  private void realizarTransacao(Crianca crianca, Atividade atividade, TipoTransacao tipoTransacao) {
    double valorTransacao =
            (tipoTransacao == TipoTransacao.CREDITO)
                    ? atividade.getValorCredito()
                    : -(atividade.getValorDebito());

    Conta criancaConta = contaRepo.findByIdCrianca(crianca.getId()).get();

    Transacao transacao = new Transacao(crianca, atividade, tipoTransacao, valorTransacao, criancaConta);

    criancaConta.setSaldo(criancaConta.getSaldo() + valorTransacao);

    transacaoRepo.save(transacao);
    contaRepo.save(criancaConta);
  }
}
