import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogoAdicionarCriancaComponent } from '../dialogo-adicionar-crianca/dialogo-adicionar-crianca.component';

@Component({
  selector: 'app-perfil-responsavel',
  templateUrl: './perfil-responsavel.component.html',
  styleUrl: './perfil-responsavel.component.scss'
})
export class PerfilResponsavelComponent {

  constructor(public dialogo: MatDialog) {

  }

  onAdicionarCrianca() {
    this.dialogo.open(DialogoAdicionarCriancaComponent, {data: 'oi'})
  }

}
