import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  constructor(private httpClient: HttpClient) { }

  adicionarCrianca(nome: string, valorMesada: number, pin: number, foto: number[]) {
    console.log(valorMesada);
    var idResponsavel = localStorage.getItem('id_responsavel');
    return this.httpClient.post('api/crianca', {nome, valorMesada, pin, idResponsavel, foto});
  }

}
