import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Perfil } from '../modelo/perfil';
import { Observable, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeletorPerfilService {

  constructor(private httpClient: HttpClient) {

  }

  listarPerfis() : Observable<Perfil[]> {
    return this.httpClient.get<Perfil[]>('api/listar-perfis')
      .pipe(
        first(),
        tap(perfil => console.log(perfil)));
  }

  autenticarPin(id: String, pin: Number) {
      return this.httpClient.post('api/autenticarPin', {id: id, pin: pin});
    }

}
