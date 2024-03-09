import { Crianca } from './../modelo/Crianca';
import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ResponsavelService } from '../servico/responsavel.service';

@Component({
  selector: 'app-dialogo-status-atv',
  templateUrl: './dialogo-status-atv.component.html',
  styleUrl: './dialogo-status-atv.component.scss'
})
export class DialogoStatusAtvComponent {

  formStatusAtv: FormGroup;

  id: String;
  titulo: String;
  criancas: Crianca[] = [];

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    private responsavelService: ResponsavelService
    ) {
      this.formStatusAtv = this.formBuilder.group({
      })
      this.id = data.id;
      this.titulo = data.titulo;

    const idResponsavel: string = localStorage.getItem('id_responsavel')!;
    this.responsavelService.listarPerfisCriancas(idResponsavel).subscribe(
      (dados: Crianca[]) => {
        // Assim que os dados forem emitidos, atribua-os à propriedade criancas
        this.criancas = dados;
      },
      (erro) => {
        // Trate qualquer erro que possa ocorrer durante a obtenção dos dados
        console.error('Ocorreu um erro ao obter os dados:', erro);
      }
    );

  }

  onSalvar() {

  }

  onCancelar() {

  }

}
