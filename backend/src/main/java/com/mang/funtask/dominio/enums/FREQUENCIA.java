package com.mang.funtask.dominio.enums;

public enum FREQUENCIA {
  DIARIA("Diaria"),
  SEMANAL("Semanal"),
  MENSAL("Mensal");

  private final String valor;

  FREQUENCIA(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }

}
