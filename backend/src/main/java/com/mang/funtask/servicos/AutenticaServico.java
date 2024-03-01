package com.mang.funtask.servicos;

import com.mang.funtask.dominio.modelos.Autenticavel;
import com.mang.funtask.dominio.modelos.Crianca;
import com.mang.funtask.dominio.modelos.Responsavel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AutenticaServico {

    private ResponsavelServico responsavelServico;
    private CriancaServico criancaServico;

    public Autenticavel encontrarPerfil(UUID id) {
        Optional<Responsavel> responsavel = responsavelServico.encontrarResponsavel(id);
        if(responsavel.isPresent()) {
            return responsavel.get();
        }

        Optional<Crianca> crianca = criancaServico.encontrarCrianca(id);
        if(crianca.isPresent()) {
            return crianca.get();
        }
        return null;
    }

    public boolean autorizarAcesso(Autenticavel perfil, int pin) {
        return perfil.getPin() == pin;
    }


}
