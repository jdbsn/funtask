import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Perfil } from '../modelo/perfil';
import { Observable, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeletorPerfilService {

  private readonly AUTENTICADO = 'autenticado';
  private readonly ID_RESPONSAVEL = 'id_responsavel';

  autenticado: boolean = false;

  constructor(private httpClient: HttpClient) {
    this.autenticado = localStorage.getItem(this.AUTENTICADO) === 'true';
  }

  listarPerfis() : Observable<Perfil[]> {
    return this.httpClient.get<Perfil[]>('api/listar-perfis')
      .pipe(
        first()
      );
  }

  autenticarPin(id: String, pin: Number, responsavel: boolean) {
    return this.httpClient.post('api/autenticarPin', {id: id, pin: pin})
      .pipe(
        tap(() => {
          if(responsavel) {
            this.autenticado = true;
            localStorage.setItem(this.AUTENTICADO, 'true');
            localStorage.setItem(this.ID_RESPONSAVEL, '' + id);
          }
        })
      );
  }

  estaAutenticado(): boolean {
    return this.autenticado;
  }

}
