import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AtividadeDTO } from '../modelo/dtos/atividadeDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AtividadeService {


  constructor(private http: HttpClient) {}

  postAtividade(atividadeDTO: any): Observable<AtividadeDTO> {
    const url = 'api/atividades/responsavel';
    return this.http.post<any>(url, atividadeDTO);
  }
}
