package com.mang.funtask.servicos;

import com.mang.funtask.dominio.dto.request.CriancaDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidadorServico {

  private Validator validator;

  public Map<String, String> validaCrianca(CriancaDTO dto) {
    Map<String, String> mensagens = new HashMap<>();

    Set<ConstraintViolation<CriancaDTO>> violacoes = validator.validate(dto);
    mensagens.putAll(this.pegarViolacao(violacoes));

    return mensagens;
  }

  public Map<String, String> pegarViolacao(Set<? extends ConstraintViolation<?>> violacoes) {
    Map<String, String> mensagens = new HashMap<>();

    violacoes.forEach(violacao -> {
      String origem = violacao.getPropertyPath().toString();
      String mensagem = violacao.getMessage();
      mensagens.put(origem, mensagem);
    });

    return mensagens;
  }

}
