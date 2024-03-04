import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Crianca } from '../../atividades-responsavel/modelo/crianca';

@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  constructor(private httpClient: HttpClient) { }

  listarPerfisCriancas(idResponsavel: string) {
    return this.httpClient.get<Crianca[]>('api/crianca');
  }

  adicionarCrianca(nome: string, valorMesada: number, pin: number, foto: number[]) {
    if(valorMesada == null) {
      valorMesada = -1;
    }
    var idResponsavel = localStorage.getItem('id_responsavel');
    return this.httpClient.post('api/crianca', {nome, valorMesada, pin, idResponsavel, foto});
  }

}