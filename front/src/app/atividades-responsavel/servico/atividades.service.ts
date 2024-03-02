import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Atividade } from '../modelo/atividade';
import { Observable, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AtividadesService {

  constructor(private httpClient: HttpClient) { }

  listarAtividades(): Observable<Atividade[]> {
    return this.httpClient.get<Atividade[]>('api/responsavel/atividades')
    .pipe(
      first(),
      tap(atividade => console.log(atividade))
    );

  }
}
