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
      id: '3c60ea6e-f945-48b2-94d8-82d00729130a',
      nome: "Davi",
      icone: "../../../assets/user_icon.png"
    },
    {
      id: '86a649a5-f10a-4cdd-b1af-68907dce2aa4',
      nome: "Livia",
      icone: "../../../assets/user_icon.png"
    },
    {
      id: '8fa13d0e-6905-455e-9001-a27ca60790f6',
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
