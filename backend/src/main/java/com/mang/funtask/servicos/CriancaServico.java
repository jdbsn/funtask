package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.dominio.dto.response.PerfilCriancaDTO;
import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.dominio.modelos.Conta;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import com.mang.funtask.repositorios.ContaRepositorio;
import com.mang.funtask.repositorios.CriancaRepositorio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriancaServico {

  private ResponsavelServico responsavelServico;
  private CriancaRepositorio criancaRepo;
  private ValidadorServico validadorServico;
  private ContaRepositorio contaRepo;

  public Map<String, String> adicionarCrianca(CriancaDTO dto) {
    Map<String, String> mensagens = new HashMap<>();
    Optional<Responsavel> responsavel = responsavelServico.encontrarResponsavel(
        dto.idResponsavel());

    if (responsavel.isEmpty()) {
      mensagens.put("responsavel", "Responsável não encontrado.");
    }

    mensagens.putAll(validadorServico.validaCrianca(dto));

    if (!mensagens.isEmpty()) {
      return mensagens;
    }

    Crianca crianca = new Crianca(dto, dto.idResponsavel());
    criancaRepo.save(crianca);

    return mensagens;
  }

  public Optional<Crianca> encontrarCrianca(UUID id) {
    return criancaRepo.findById(id);
  }

  public Optional<List<Crianca>> encontrarCriancasPorResponsavel(UUID idResponsavel) {
    return criancaRepo.encontrarPorIdResponsavel(idResponsavel);
  }

  public PerfilCriancaDTO encontrarPerfilCrianca(UUID idCrianca) {
    Optional<Crianca> crianca = encontrarCrianca(idCrianca);

    if(crianca.isEmpty()) {
      return null;
    }

    Conta conta = contaRepo.findByIdCrianca(idCrianca).get();
    Crianca crianca1 = crianca.get();

    PerfilCriancaDTO dto = new PerfilCriancaDTO(crianca1.getId(), crianca1.getNome(),
        Base64.encodeBase64String(crianca1.getFoto()), conta.getSaldo());

    return dto;
  }

  public List<PerfisDTO> listarCriancasPorResponsavel(UUID idResponsavel) {
    Optional<List<Crianca>> criancas = criancaRepo.encontrarPorIdResponsavel(idResponsavel);

    if (criancas.isEmpty()) {
      return Collections.emptyList();
    }

    List<PerfisDTO> perfis = new ArrayList<>();
    criancas.get().forEach(crianca -> perfis.add(new PerfisDTO(crianca.getId(), crianca.getNome(),
            Base64.encodeBase64String(crianca.getFoto()), false)));

    return perfis;
  }

  public void atualizarCrianca(Crianca crianca) {
    this.criancaRepo.save(crianca);
  }

}
