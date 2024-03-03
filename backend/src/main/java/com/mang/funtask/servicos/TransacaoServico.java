package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.TransacaoDTO;
import com.mang.funtask.dominio.enums.TipoTransacao;
import com.mang.funtask.dominio.modelos.Atividade;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Transacao;
import com.mang.funtask.repositorios.TransacaoRepositorio;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServico {

  private final TransacaoRepositorio transacaoRep;
  private final AtividadeServico atividadeServico;
  private final CriancaServico criancaServico;

  public TransacaoServico(TransacaoRepositorio transacaoRep, AtividadeServico atividadeServico,
      CriancaServico criancaServico) {
    this.transacaoRep = transacaoRep;
    this.atividadeServico = atividadeServico;
    this.criancaServico = criancaServico;
  }

  public String atualizarMesadaPorAtividade(TransacaoDTO transacaoDTO) {
    Optional<Atividade> atividade = this.atividadeServico.encontrarAtividadePorID(
        transacaoDTO.idAtividade());
    if (atividade.isEmpty()) {
      return "Atividade não encontrada";
    }

    Transacao transacao = new Transacao(transacaoDTO, atividade.get().getId());
    atualizarMesada(transacao, atividade.get());
    transacaoRep.save(transacao);

    return "Transação feita com sucesso";
  }

  private void atualizarMesada(Transacao transacao, Atividade atividade) {
    Optional<Crianca> crianca = this.criancaServico.encontrarCrianca(atividade.getIdCrianca());

    if (crianca.isEmpty()) {
      return;
    }
    Crianca criancaMesada = crianca.get();

    if (transacao.getTipoTransacao().equals(TipoTransacao.CREDITO)) {
      criancaMesada.setValorMesada(criancaMesada.getValorMesada() + atividade.getValorCredito());
    }

    if (transacao.getTipoTransacao().equals(TipoTransacao.DEBITO)) {
      criancaMesada.setValorMesada(criancaMesada.getValorMesada() - atividade.getValorDebito());
    }

    this.criancaServico.atualizarCrianca(criancaMesada);
  }
}
