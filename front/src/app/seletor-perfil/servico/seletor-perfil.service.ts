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
  private readonly ID_CRIANCA = 'id_crianca';

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
          } else {
            this.autenticado = true;
            localStorage.setItem(this.AUTENTICADO, 'true');
            localStorage.setItem(this.ID_CRIANCA, '' + id);
          }
        })
      );
  }

  estaAutenticadoResponsavel(): boolean {
    var x = localStorage.getItem(this.ID_RESPONSAVEL)
    console.log("Responsável - " + x);
    if(localStorage.getItem(this.ID_RESPONSAVEL) == null) {
      return false;
    }
    return this.autenticado;
  }

  estaAutenticadoCrianca(): boolean {
    var x = localStorage.getItem(this.ID_CRIANCA)
    console.log("Criança - " + x);
    if(localStorage.getItem(this.ID_CRIANCA) === null) {
      return false;
    }
    return this.autenticado;
  }

}
