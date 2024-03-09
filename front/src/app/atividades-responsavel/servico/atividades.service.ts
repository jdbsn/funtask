import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Atividade } from '../modelo/atividade';
import { Observable, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AtividadesService {

  private apiUrl = 'api/atividades'

  constructor(private httpClient: HttpClient) { }

  listarAtividades(): Observable<Atividade[]> {
    return this.httpClient.get<Atividade[]>(this.apiUrl)
    .pipe(
      first(),
      tap(atividade => console.log(atividade))
    );
  }

  editarAtividade(atividade: any): Observable<any> {
    console.log(atividade);
    return this.httpClient.put(this.apiUrl, atividade);
  }

  apagarAtividade(id: string): Observable<any> {
    const url = `${this.apiUrl}/${id}`;
    console.log(id);
    console.log(url);
    return this.httpClient.delete(url);
  }
}
