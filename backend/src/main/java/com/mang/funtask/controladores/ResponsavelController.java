package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.response.PerfisDTO;
import com.mang.funtask.servicos.ResponsavelServico;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ResponsavelController {

    private static final UUID ID_RESPONSAVEL = UUID.fromString("8fa13d0e-6905-455e-9001-a27ca60790f6");
    private ResponsavelServico responsavelServico;

    @GetMapping("/api/listar-perfis")
    public ResponseEntity<List<PerfisDTO>> listarPerfis() {
        List<PerfisDTO> perfis = responsavelServico.encontrarPerfis(ID_RESPONSAVEL);

        if(perfis.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(perfis);
    }

}
