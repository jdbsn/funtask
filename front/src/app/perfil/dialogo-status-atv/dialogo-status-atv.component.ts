import { Crianca } from './../modelo/Crianca';
import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ResponsavelService } from '../servico/responsavel.service';

@Component({
  selector: 'app-dialogo-status-atv',
  templateUrl: './dialogo-status-atv.component.html',
  styleUrl: './dialogo-status-atv.component.scss'
})
export class DialogoStatusAtvComponent {

  formStatusAtv: FormGroup;

  idAtv: String;
  titulo: String;
  criancas: Crianca[] = [];

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    private responsavelService: ResponsavelService,
    private dialogRef: MatDialogRef<DialogoStatusAtvComponent>
    ) {
      this.formStatusAtv = this.formBuilder.group({
        idCrianca: [null],
        status: [null]
      })
      this.idAtv = data.id;
      this.titulo = data.titulo;

    const idResponsavel: string = localStorage.getItem('id_responsavel')!;
    this.responsavelService.listarPerfisCriancas(idResponsavel).subscribe(
      (dados: Crianca[]) => {
        this.criancas = dados;
      },
      (erro) => {
        console.error('Ocorreu um erro ao obter os dados:', erro);
      }
    );

  }

  onSalvar() {
    var idCrianca = this.formStatusAtv.value.idCrianca;
    var status = this.formStatusAtv.value.status;
    this.responsavelService.alterarStatusAtv(this.idAtv, idCrianca, status).subscribe(
      {
        next: () => {
          this.dialogRef.close();
        },
        error: (erro) => {
          console.log(erro);
        }
      });;
  }

}
