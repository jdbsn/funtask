package com.mang.funtask.dominio.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoTransacao {
  DEBITO("Debito"),
  CREDITO("Credito"),
  MESADA("Mesada");

  private final String valor;

}
