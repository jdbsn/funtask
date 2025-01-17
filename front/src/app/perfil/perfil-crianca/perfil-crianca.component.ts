import { Observable, pipe } from 'rxjs';
import { CriancaService } from './../servico/crianca.service';
import { Component } from '@angular/core';
import { PerfilCrianca } from '../modelo/PerfilCrianca';
import { Router } from '@angular/router';
import { Atividade } from '../../atividades-responsavel/modelo/atividade';
import { AtividadesService } from '../../atividades-responsavel/servico/atividades.service';
import { DialogExtratoComponent } from '../dialog-extrato/dialog-extrato.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-perfil-crianca',
  templateUrl: './perfil-crianca.component.html',
  styleUrl: './perfil-crianca.component.scss'
})
export class PerfilCriancaComponent {

  crianca: PerfilCrianca = {nome: "", saldo: 0, id: "", foto: ""};
  atividades$: Observable<Atividade[]>;
  id: string;

  constructor(
    private router: Router,
    private criancaService: CriancaService,
    private atividadesService: AtividadesService,
    private dialogo: MatDialog
  ) {
    this.id = localStorage.getItem("id_crianca")!;

    this.criancaService.encontrarDados(this.id).subscribe(crianca => {
      this.crianca.nome = crianca.nome;
      this.crianca.saldo = crianca.saldo;
    });

    this.atividades$ = this.atividadesService.listarAtividades();

  }

  abrirDialogExtrato() {
    this.dialogo.open(DialogExtratoComponent, {
      data: this.id,
      enterAnimationDuration:'500ms',
      exitAnimationDuration:'500ms'
    });
  }

  onTrocarPerfil() {
    localStorage.clear();
    this.router.navigate(['selecionar-perfil']);
  }

  onLogout() {

  }

}
