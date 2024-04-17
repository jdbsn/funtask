package com.mang.funtask.controladores;

import com.mang.funtask.dominio.dto.request.AcessoPerfilDTO;
import com.mang.funtask.dominio.dto.request.LoginDTO;
import com.mang.funtask.dominio.modelos.Autenticavel;
import com.mang.funtask.servicos.AutenticaServico;
import com.mang.funtask.servicos.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AutenticaController {

  private AutenticaServico autenticaServico;
  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<String> autenticarResponsavel(@RequestBody LoginDTO loginDTO) {
    try {
      var userSenha = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.senha());
      this.authenticationManager.authenticate(userSenha);

      var token = tokenService.generateToken(loginDTO.email());

      return ResponseEntity.status(HttpStatus.OK).body(token);
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha incorreto.");
    }
  }

  @PostMapping("/autenticarPin")
  public ResponseEntity<String> autenticarPin(@RequestBody AcessoPerfilDTO dto) {
    Autenticavel perfil = autenticaServico.encontrarPerfil(dto.id());

    if (perfil == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Perfil não encontrado.");
    }

    if (!autenticaServico.autorizarAcesso(perfil, dto.pin())) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("PIN incorreto.");
    }

    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
