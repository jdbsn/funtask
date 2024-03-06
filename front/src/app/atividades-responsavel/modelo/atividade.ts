import { Frequencia } from './frequencia';
import { Crianca } from './crianca';

export interface Atividade {
  id: string
  descricao: string;
  valorCredito: number;
  valorDebito: number;
  frequencia: string;
  idCrianca: string;
  nomeCrianca: string;
  fotoCrianca: string
}
