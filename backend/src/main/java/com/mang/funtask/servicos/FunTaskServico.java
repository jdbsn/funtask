package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FunTaskServico {

  private CriancaServico criancaServico;
  private ResponsavelServico responsavelServico;

  public List<PerfisDTO> encontrarPerfis(String email) {
    Optional<Responsavel> responsavelOpt = responsavelServico.encontrarPorEmail(email);

    if (responsavelOpt.isEmpty()) {
      return Collections.emptyList();
    }

    List<PerfisDTO> perfis = new ArrayList<>();
    Responsavel responsavel = responsavelOpt.get();
    perfis.add(new PerfisDTO(responsavel.getId(), responsavel.getNome(), null, true));

    Optional<List<Crianca>> criancasOpt = criancaServico.encontrarCriancasPorResponsavel(responsavel.getId());

    if (criancasOpt.isPresent()) {
      List<Crianca> criancas = criancasOpt.get();

      criancas.forEach(c ->
          perfis.add(
              new PerfisDTO(c.getId(), c.getNome(), Base64.encodeBase64String(c.getFoto()), false))
      );
    }

    return perfis;
  }

}
