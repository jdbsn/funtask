import { SeletorPerfilService } from './../servico/seletor-perfil.service';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogoPinComponent } from '../dialogo-pin/dialogo-pin.component';
import { Observable, map } from 'rxjs';
import { Perfil } from '../modelo/perfil';

@Component({
  selector: 'app-seletor-perfil',
  templateUrl: './seletor-perfil.component.html',
  styleUrl: './seletor-perfil.component.scss'
})
export class SeletorPerfilComponent {

  private readonly FOTO_PADRAO = '../../../assets/user_icon.png';
  listaPerfil$: Observable<Perfil[]>;

  constructor(public dialogo: MatDialog, private seletorPerfilServico: SeletorPerfilService) {
    this.listaPerfil$ = this.seletorPerfilServico.listarPerfis()
      .pipe(
        map(perfis => perfis.map(perfil => ({
          ...perfil,
          foto: perfil.foto || this.FOTO_PADRAO
        })))
      );
  }

  onSelecionado(id: string, responsavel: boolean, animacaoAbrir: string, animacaoFechar: string) {
    this.dialogo.open(DialogoPinComponent, {
      data: {
        id,
        responsavel
      },
      enterAnimationDuration: animacaoAbrir,
      exitAnimationDuration: animacaoFechar
    });
  }

}
