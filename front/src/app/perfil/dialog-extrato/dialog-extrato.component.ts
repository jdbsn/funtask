import { Component, Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Transacao } from '../modelo/Transacao';
import { CriancaService } from '../servico/crianca.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-extrato',
  templateUrl: './dialog-extrato.component.html',
  styleUrl: './dialog-extrato.component.scss'
})
export class DialogExtratoComponent {
  transacoes: Observable<Transacao[]>;

  constructor(private criancaService: CriancaService, @Inject(MAT_DIALOG_DATA) public data: string) {
    this.transacoes = this.criancaService.listarExtrato(this.data);
  }
}
