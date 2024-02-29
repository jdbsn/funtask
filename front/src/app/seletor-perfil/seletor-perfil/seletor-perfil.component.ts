import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogoPinComponent } from '../dialogo-pin/dialogo-pin.component';

@Component({
  selector: 'app-seletor-perfil',
  templateUrl: './seletor-perfil.component.html',
  styleUrl: './seletor-perfil.component.scss'
})
export class SeletorPerfilComponent {

  listaPerfil = [
    {
      id: '4829',
      nome: "Davi",
      icone: "../../../assets/user_icon.png"
    },
    {
      id: '3019',
      nome: "Livia",
      icone: "../../../assets/user_icon.png"
    },
    {
      id: '7204',
      nome: "Responsável",
      icone: "../../../assets/user_icon.png"
    }
  ];

  constructor(public dialogo: MatDialog) {

  }

  onSelecionado(id: string) {
    this.dialogo.open(DialogoPinComponent, {data: id});
  }

}
