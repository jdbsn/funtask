package com.mang.funtask.dominio.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Frequencia {
  DIARIA("Diaria"),
  SEMANAL("Semanal"),
  MENSAL("Mensal");

  private final String valor;

}
