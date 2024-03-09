import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogoAdicionarCriancaComponent } from '../dialogo-adicionar-crianca/dialogo-adicionar-crianca.component';
import { ResponsavelService } from '../servico/responsavel.service';
import { map, pipe, tap } from 'rxjs';
import { Crianca } from '../modelo/Crianca';

@Component({
  selector: 'app-perfil-responsavel',
  templateUrl: './perfil-responsavel.component.html',
  styleUrl: './perfil-responsavel.component.scss'
})
export class PerfilResponsavelComponent {

  numeroFilhos: number;
  criancas: Crianca[] = [];

  constructor(public dialogo: MatDialog, private responsavelService: ResponsavelService) {
    this.numeroFilhos = 0;
    const idResponsavel: string = localStorage.getItem('id_responsavel')!;

    this.responsavelService.listarPerfisCriancas(idResponsavel).pipe(
      map(criancas => ({ criancas, tamanhoLista: criancas.length }))
    ).subscribe(({ criancas, tamanhoLista }) => {
      this.criancas = criancas;
      this.numeroFilhos = tamanhoLista;
    });
  }

  onAdicionarCrianca() {
    console.log(this.numeroFilhos)
    this.dialogo.open(DialogoAdicionarCriancaComponent, {data: ''})
  }

}
