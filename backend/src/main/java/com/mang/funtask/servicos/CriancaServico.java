package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.AcessoPerfilDTO;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.repositorios.CriancaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CriancaServico {

    private CriancaRepositorio criancaRepo;

    public Optional<Crianca> encontrarCrianca(AcessoPerfilDTO dto) {
        return criancaRepo.findById(dto.id());
    }

    public boolean autorizarAcesso(Crianca crianca, int pin) {
        return pin == crianca.getPin();
    }

}
