export class AtividadeDTO {
  titulo: string;
  descricao: string;
  valorCredito: number;
  valorDebito: number;
  frequencia: string;
  idResponsavel: string;

  constructor(titulo: string, descricao: string, valorCredito: number, valorDebito: number, frequencia: string, idResponsavel: string) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.valorCredito = valorCredito;
    this.valorDebito = valorDebito;
    this.frequencia = frequencia;
    this.idResponsavel = idResponsavel;
  }
}
