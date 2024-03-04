export class AtividadeDTO {
  descricao: string;
  valorCredito: number;
  valorDebito: number;
  frequencia: string;
  idCrianca: string;

  constructor(descricao: string, valorCredito: number, valorDebito: number, frequencia: string, idCrianca: string) {
    this.descricao = descricao;
    this.valorCredito = valorCredito;
    this.valorDebito = valorDebito;
    this.frequencia = frequencia;
    this.idCrianca = idCrianca;
  }
}
