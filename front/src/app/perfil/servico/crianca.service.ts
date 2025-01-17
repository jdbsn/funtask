import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PerfilCrianca } from '../modelo/PerfilCrianca';
import { Observable, first, tap } from 'rxjs';
import { Transacao } from '../modelo/Transacao';

@Injectable({
  providedIn: 'root'
})
export class CriancaService {

  constructor(private httpClient: HttpClient) { }

  encontrarDados(idCrianca: String) {
    return this.httpClient.get<PerfilCrianca>('/api/crianca/' + idCrianca);
  }

  listarExtrato(id: string): Observable<Transacao[]> {
    console.log(id)
    var rota = '/api/responsavel/transacao/' + id
    console.log(rota)
    return this.httpClient.get<Transacao[]>(rota)
    .pipe(
      first(),
      tap(transacao => console.log(transacao))
    );
  }

}
