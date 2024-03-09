import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialogo-status-atv',
  templateUrl: './dialogo-status-atv.component.html',
  styleUrl: './dialogo-status-atv.component.scss'
})
export class DialogoStatusAtvComponent {

  valor;

  constructor(    @Inject(MAT_DIALOG_DATA) public data: {
    id: string,
    responsavel: boolean
  }) {

    this.valor = this.data.id

  }

}
