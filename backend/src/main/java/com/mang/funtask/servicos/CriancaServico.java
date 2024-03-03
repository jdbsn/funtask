package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import com.mang.funtask.repositorios.CriancaRepositorio;

import java.util.*;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
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

  public Optional<List<Crianca>> encontrarCriancasPorResponsavel(UUID idResponsavel) {
    return criancaRepo.encontrarPorIdResponsavel(idResponsavel);
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

}
