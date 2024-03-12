import { Crianca } from "./Crianca";

export interface Transacao {
  id: string;
  descricao: string;
  valorTransacao: number;
  tipoTransacao: string;
  saldoAnterior: number;
  saldoAtual: number;
  crianca: Crianca;
  horaTransacao: string;
}
