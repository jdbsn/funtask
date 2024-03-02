import { Frequencia } from './frequencia';
import { Crianca } from './crianca';

export interface Atividade {
  descricao: string;
  valorCredito: number;
  valorDebito: number;
  frequencia: Frequencia;
  crianca: Crianca;
}
