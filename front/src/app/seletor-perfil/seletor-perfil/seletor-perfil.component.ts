import { Component } from '@angular/core';

@Component({
  selector: 'app-seletor-perfil',
  templateUrl: './seletor-perfil.component.html',
  styleUrl: './seletor-perfil.component.scss'
})
export class SeletorPerfilComponent {

  listaPerfil = [
    {
      nome: "Davi",
      icone: "../../../assets/user_icon.png"
    },
    {
      nome: "Livia",
      icone: "../../../assets/user_icon.png"
    },
    {
      nome: "Responsável",
      icone: "../../../assets/user_icon.png"
    }
  ];

  onSelecionado() {
    console.log("click")
  }

}
