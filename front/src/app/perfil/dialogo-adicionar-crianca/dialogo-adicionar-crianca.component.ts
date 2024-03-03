import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialogo-adicionar-crianca',
  templateUrl: './dialogo-adicionar-crianca.component.html',
  styleUrl: './dialogo-adicionar-crianca.component.scss'
})
export class DialogoAdicionarCriancaComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: string) {

  }

}
