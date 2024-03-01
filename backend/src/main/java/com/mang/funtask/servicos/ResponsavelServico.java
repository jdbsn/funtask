package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.PerfisDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import com.mang.funtask.repositorios.ResponsavelRepositorio;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ResponsavelServico {

    private ResponsavelRepositorio responsavelRepo;
    private CriancaServico criancaServico;

    public Optional<Responsavel> encontrarResponsavel(UUID id) {
        return responsavelRepo.findById(id);
    }

    public List<PerfisDTO> encontrarPerfis(UUID idResponsavel) {
        List<PerfisDTO> perfis = new ArrayList<>();

        Optional<Responsavel> responsavel = responsavelRepo.findById(idResponsavel);
        Optional<List<Crianca>> criancas = criancaServico.encontrarCriancaPorResponsavel(idResponsavel);

        if(responsavel.isPresent()) {
            Responsavel responsavel1 = responsavel.get();
            perfis.add(new PerfisDTO(responsavel1.getId(), responsavel1.getNome(), null));
        }
        if(criancas.isPresent()) {
            List<Crianca> criancas1 = criancas.get();

            criancas1.forEach(c ->
                perfis.add(new PerfisDTO(c.getId(), c.getNome(), Base64.encodeBase64String(c.getFoto())))
            );
        }

        return perfis;
    }

}
