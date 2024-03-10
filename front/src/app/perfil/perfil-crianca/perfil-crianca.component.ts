import { pipe } from 'rxjs';
import { CriancaService } from './../servico/crianca.service';
import { Component } from '@angular/core';
import { PerfilCrianca } from '../modelo/PerfilCrianca';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil-crianca',
  templateUrl: './perfil-crianca.component.html',
  styleUrl: './perfil-crianca.component.scss'
})
export class PerfilCriancaComponent {

  crianca: PerfilCrianca = {nome: "", saldo: 0, id: "", foto: ""};

  constructor(
    private router: Router,
    private criancaService: CriancaService
  ) {
    const id: string = localStorage.getItem("id_crianca")!;

    this.criancaService.encontrarDados(id).subscribe(crianca => {
      this.crianca.nome = crianca.nome;
      this.crianca.saldo = crianca.saldo;
    });

  }

  onTrocarPerfil() {
    localStorage.clear();
    this.router.navigate(['selecionar-perfil']);
  }

  onLogout() {

  }

}
