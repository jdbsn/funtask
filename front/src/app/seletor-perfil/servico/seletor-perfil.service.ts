import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SeletorPerfilService {

  constructor(private httpClient: HttpClient) {

  }

  autenticarPin(id: String, pin: Number) {
      return this.httpClient.post('api/autenticarPin', {id: id, pin: pin});
    }

}
