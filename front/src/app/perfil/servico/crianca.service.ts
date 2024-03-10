import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PerfilCrianca } from '../modelo/PerfilCrianca';

@Injectable({
  providedIn: 'root'
})
export class CriancaService {

  constructor(private httpClient: HttpClient) { }

  encontrarDados(idCrianca: String) {
    return this.httpClient.get<PerfilCrianca>('/api/crianca/' + idCrianca);
  }

}
