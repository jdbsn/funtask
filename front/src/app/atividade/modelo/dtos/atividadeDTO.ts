export class AtividadeDTO {
  descricao: string;
  valorCredito: number;
  valorDebito: number;
  frequencia: string;
  criancaId: string;

  constructor(descricao: string, valorCredito: number, valorDebito: number, frequencia: string, criancaId: string) {
    this.descricao = descricao;
    this.valorCredito = valorCredito;
    this.valorDebito = valorDebito;
    this.frequencia = frequencia;
    this.criancaId = criancaId;
  }
}
