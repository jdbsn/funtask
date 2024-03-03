package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import com.mang.funtask.servicos.CriancaServico;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crianca")
@AllArgsConstructor
public class CriancaController {

    private CriancaServico criancaServico;

    @PostMapping
    public ResponseEntity<String> adicionarCrianca(@RequestBody CriancaDTO crianca) {
        boolean feito = criancaServico.adicionarCrianca(crianca);

        if(!feito) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cadastro não foi feito.");
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
